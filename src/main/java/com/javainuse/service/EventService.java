package com.javainuse.service;

import com.javainuse.model.Event;
import com.javainuse.model.dto.EventRequest;
import com.javainuse.model.dto.EventResponse;
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
        Event event = convertToEntity(eventRequest);
        return new EventResponse(eventRepository.save(event));
    }

    public List<EventResponse> getAllEvents() {
        return ((Collection<Event>) eventRepository.findAll()).stream()
                .map(EventResponse::new)
                .collect(Collectors.toList());
    }

    private Event convertToEntity(EventRequest request) {
        Event event = new Event();
        event.setRoom(roomService.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found by")));
        event.setUser(userService.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found.")));
        event.setStartTime(new Date(request.getStartTimeNumber()));
        event.setFinishTime(new Date(request.getFinishTimeNumber()));
        return event;
    }

    public List<EventResponse> getAllEventsByUserId(Long userId) {
        return eventRepository.findAllByUserId(userId).stream()
                .map(EventResponse::new)
                .collect(Collectors.toList());
    }
}


