package com.RegistrationApp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.RegistrationApp.demo.nodel.User;
import com.RegistrationApp.demo.repository.UserRepository;
import com.RegistrationApp.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    // Handle GET requests
    @GetMapping("/register")
    public ResponseEntity<String> getRegistrationInfo() {
        // Return registration information or instructions
        return ResponseEntity.ok("GET request to /api/register - Registration info here");
    }

    // Handle POST requests
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Handle registration logic here
        return userRepository.save(user);
    }
}
