package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.ApplicationConfig;
import com.example.solidbankingapp.DAO.UserDAO;
import com.example.solidbankingapp.entity.AuthenticationResponse;
import com.example.solidbankingapp.security.User;
import com.example.solidbankingapp.service.AuthenticationService;
import com.example.solidbankingapp.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDAO userDAO;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService, UserDAO userDAO) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDAO = userDAO;
    }

    @Override
    public AuthenticationResponse authenticate(String username, String password) throws UsernameNotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );
        User user = userDAO.findByUsername(username);
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
