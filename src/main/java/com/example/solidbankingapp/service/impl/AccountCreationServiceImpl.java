package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.*;
import com.example.solidbankingapp.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;
    private long lastAccountNumber = 1;

    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public String createNewAccount(String accountType, String clientID) {
        if (accountType == null) {
            return "Undefined AccountTypeRequest";
        }
        String accountNumber = String.format("%03d%06d", 1, lastAccountNumber);
        Account account = null;
        if (accountType.equals("FIXED")) account = new FixedAccount(accountNumber, clientID, 0.0);
        if (accountType.equals("SAVING")) account = new SavingAccount(accountNumber, clientID, 0.0);
        if (accountType.equals("CHECKING")) account = new CheckingAccount(accountNumber, clientID, 0.0);
        incrementLastAccountNumber();
        assert account != null;
        accountDAO.save(account);
        return "Bank account created";
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
