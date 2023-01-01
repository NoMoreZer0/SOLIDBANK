package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AccountListingService {
    List<Account> getClientAccounts(String clientID);
}
