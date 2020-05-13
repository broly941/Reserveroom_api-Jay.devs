package com.javainuse.service;

import com.javainuse.model.Event;
import com.javainuse.model.dto.EventRequest;
import com.javainuse.model.dto.EventResponse;
import com.javainuse.model.dto.RoomResponse;
import com.javainuse.model.dto.UserResponse;
import com.javainuse.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final JwtUserDetailsService userService;
    private final RoomService roomService;

    public EventResponse create(EventRequest eventRequest) {
        Event event = convertDto2Entity(eventRequest);
        return convertEntity2Dto(eventRepository.save(event));
    }

    public List<EventResponse> getAllEvents() {
        return ((Collection<Event>) eventRepository.findAll()).stream()
                .map(this::convertEntity2Dto)
                .collect(Collectors.toList());
    }

    private Event convertDto2Entity(EventRequest dto) {
        Event event = new Event();
        event.setRoom(roomService.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found by")));
        event.setUser(userService.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found.")));
        event.setStartTime(new Date(dto.getStartTimeNumber()));
        event.setFinishTime(new Date(dto.getFinishTimeNumber()));
        return event;
    }

    private EventResponse convertEntity2Dto(Event event) {
        EventResponse dto = new EventResponse();
        dto.setStartDate(event.getStartTime());
        dto.setFinishDate(event.getFinishTime());
        dto.setUser(new UserResponse(event.getUser()));
        dto.setRoom(new RoomResponse(event.getRoom()));
        return dto;
    }
}


