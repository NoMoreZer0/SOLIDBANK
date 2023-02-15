package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(String username, String password);
}
