package com.example.solidbankingapp.controller;

import com.example.solidbankingapp.entity.UserRequest;
import com.example.solidbankingapp.service.RegistrationService;
import com.example.solidbankingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserRequest userRequest) {
        boolean ret = registrationService.saveUser(userRequest.getUsername(), userRequest.getPassword());
        if (!ret) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user already exist!"); }
        return ResponseEntity.ok("user created successfully");
    }
}
