package com.javainuse.controller;

import com.javainuse.model.dto.RoomRequest;
import com.javainuse.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody RoomRequest dto) {
        return new ResponseEntity(roomService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllRooms() {
        return new ResponseEntity(roomService.getAllRooms(), HttpStatus.OK);
    }
}
