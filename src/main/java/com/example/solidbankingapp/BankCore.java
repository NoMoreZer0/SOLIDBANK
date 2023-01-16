package com.example.solidbankingapp;

import com.example.solidbankingapp.service.AccountCreationService;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreationService;

    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    private void incremenetLastAccountNumber() {
        lastAccountNumber++;
    }
}
