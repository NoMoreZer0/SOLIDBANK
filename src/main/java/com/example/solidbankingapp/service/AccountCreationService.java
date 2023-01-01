package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.AccountType;
import org.springframework.stereotype.Component;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
