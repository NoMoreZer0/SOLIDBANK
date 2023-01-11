package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.*;
import com.example.solidbankingapp.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpl implements AccountCreationService {
    @Autowired
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String accountNumber = String.format("%03d%06d", 1, accountID);
        Account account = null;
        switch (accountType) {
            case FIXED -> account = new FixedAccount(accountNumber, clientID, 0.0);
            case SAVING -> account = new SavingAccount(accountNumber, clientID, 0.0);
            case CHECKING -> account = new CheckingAccount(accountNumber, clientID, 0.0);
        }
        accountDAO.save(account);
    }
}
