package com.javainuse.controller;

import com.javainuse.model.dto.UserResponse;
import com.javainuse.service.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final JwtUserDetailsService userDetailsService;

    @GetMapping
    ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userDetailsService.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByName(@PathVariable String username) {
        log.info("Get user by name {}.", username);
        return ResponseEntity.ok(userDetailsService.getUserByName(username));
    }
}