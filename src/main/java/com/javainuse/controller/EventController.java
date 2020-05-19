package com.javainuse.controller;

import com.javainuse.model.dto.EventRequest;
import com.javainuse.model.dto.EventResponse;
import com.javainuse.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(("/api/events"))
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        log.info("Create event with roomId: {} - userId: {} - startDate: {} - finishDate: {}.",
                eventRequest.getRoomId(), eventRequest.getUserId(),
                new Date(eventRequest.getStartTimeNumber()),
                new Date(eventRequest.getFinishTimeNumber()));
        return new ResponseEntity(eventService.create(eventRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        log.info("Get all events.");
        List<EventResponse> allEvents = eventService.getAllEvents();
        return ResponseEntity.ok(allEvents);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllEventsByUserId(@PathVariable Long userId) {
        log.info("Get all events by userId {}.", userId);
        List<EventResponse> allEvents = eventService.getAllEventsByUserId(userId);
        return ResponseEntity.ok(allEvents);
    }
}
