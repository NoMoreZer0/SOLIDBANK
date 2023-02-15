package com.example.solidbankingapp.controller;

import com.example.solidbankingapp.entity.AuthenticationResponse;
import com.example.solidbankingapp.entity.UserRequest;
import com.example.solidbankingapp.service.AuthenticationService;
import com.example.solidbankingapp.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(userRequest.getUsername(), userRequest.getPassword()));
    }
}
