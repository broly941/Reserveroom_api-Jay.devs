package com.javainuse.controller;

import com.javainuse.model.Event;
import com.javainuse.model.dto.EventRequest;
import com.javainuse.model.dto.EventResponse;
import com.javainuse.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(("/api/events"))
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        return new ResponseEntity(eventService.create(eventRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        List<EventResponse> allEvents = eventService.getAllEvents();
        return new ResponseEntity(allEvents, HttpStatus.OK);
    }
}
