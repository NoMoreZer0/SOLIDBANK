package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.UserDAO;
import com.example.solidbankingapp.security.User;
import com.example.solidbankingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userDAO.existsByUsername(username)) {
            throw new UsernameNotFoundException("User not found!");
        }
        return userDAO.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDAO.existsByUsername(username);
    }

    @Override
    public User getByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
