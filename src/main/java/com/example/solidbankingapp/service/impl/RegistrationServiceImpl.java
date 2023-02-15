package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.UserDAO;
import com.example.solidbankingapp.security.User;
import com.example.solidbankingapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean saveUser(String username, String password) {
        if (userDAO.existsByUsername(username)) {
            return false;
        }
        String encodedPassword = passwordEncoder.encode(password);
        userDAO.save(new User(username, encodedPassword));
        return true;
    }
}
