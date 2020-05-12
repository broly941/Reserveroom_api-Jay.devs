package com.javainuse.controller;

import com.javainuse.model.dto.UserResponse;
import com.javainuse.service.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}