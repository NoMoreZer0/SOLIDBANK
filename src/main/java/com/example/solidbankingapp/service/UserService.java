package com.example.solidbankingapp.service;

import com.example.solidbankingapp.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean existsByUsername(String username);
    User getByUsername(String username);
}
