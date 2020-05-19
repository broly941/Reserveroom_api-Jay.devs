package com.javainuse.service;

import com.javainuse.model.User;
import com.javainuse.model.dto.UserRequest;
import com.javainuse.model.dto.UserResponse;
import com.javainuse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public UserResponse create(UserRequest dto) {
        User user = convertToEntity(dto);
        return new UserResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return ((Collection<User>) userRepository.findAll()).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    private User convertToEntity(UserRequest dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setMobilePhoneNumber(dto.getMobilePhoneNumber());
        return user;
    }

    public UserResponse getUserByName(String username) {
        return new UserResponse(userRepository.findByUserName(username));
    }
}