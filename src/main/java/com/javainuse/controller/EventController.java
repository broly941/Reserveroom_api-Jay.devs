package com.javainuse.controller;

import com.javainuse.model.dto.EventRequest;
import com.javainuse.model.dto.EventResponse;
import com.javainuse.model.dto.JwtResponse;
import com.javainuse.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity(eventService.create(eventRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents() {
        log.info("Get all events.");
        List<EventResponse> allEvents = eventService.getAllEvents();
        return ResponseEntity.ok(allEvents);

    }

    @GetMapping("/byName/{username}")
    public ResponseEntity<?> getAllEventsByName(@PathVariable String username) {
        //todo process this. now returns for all.
        log.info("Get all events by name {}.", username);
        List<EventResponse> allEvents = eventService.getAllEvents();
        return ResponseEntity.ok(allEvents);
    }
}
