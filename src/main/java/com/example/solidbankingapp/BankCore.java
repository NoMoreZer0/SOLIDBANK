package com.example.solidbankingapp;

import com.example.solidbankingapp.entity.AccountType;
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

    public void createNewAccount(String accountType, String clientID) {
        if (accountType == null || accountType.equals("")) {
            System.out.println("Undefined AccountType");
            return;
        }
        if (accountType.equals("FIXED")) accountCreationService.create(AccountType.FIXED, id, clientID, lastAccountNumber);
        if (accountType.equals("CHECKING")) accountCreationService.create(AccountType.CHECKING, id, clientID, lastAccountNumber);
        if (accountType.equals("SAVING")) accountCreationService.create(AccountType.SAVING, id, clientID, lastAccountNumber);
        incremenetLastAccountNumber();
        System.out.println("Bank account created\n");
    }

    private void incremenetLastAccountNumber() {
        lastAccountNumber++;
    }
}
