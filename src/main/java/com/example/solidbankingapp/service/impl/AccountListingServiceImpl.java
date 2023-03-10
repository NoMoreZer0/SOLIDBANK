package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountListingServiceImpl implements AccountListingService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getAllAccounts() {
        return (List<Account>) accountDAO.findAll();
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> allAccounts = (List<Account>) accountDAO.findAll();
        List<Account> clientAccounts = new ArrayList<>();
        for (Account acc : allAccounts) {
            if (acc.getClientID().equals(clientID)) clientAccounts.add(acc);
        }
        return clientAccounts;
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, String accountType) {
        List<Account> allAccounts = (List<Account>) accountDAO.findAll();
        List<Account> clientAccountsByType = new ArrayList<>();
        for (Account acc : allAccounts) {
            if (acc.getClientID().equals(clientID) && acc.getAccountType().equals(accountType)) {
                clientAccountsByType.add(acc);
            }
        }
        return clientAccountsByType;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        List<Account> allAccounts = (List<Account>) accountDAO.findAll();
        Account clientAcc = null;
        for (Account acc : allAccounts) {
            if (acc.getClientID().equals(clientID) && acc.getId().equals(accountID)) {
                clientAcc = acc;
            }
        }
        return clientAcc;
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        List<Account> allAccounts = (List<Account>) accountDAO.findAll();
        Account clientAcc = null;
        for (Account acc : allAccounts) {
            if (acc.getClientID().equals(clientID) && acc.getId().equals(accountID) && (acc.getAccountType().equals("SAVING") || acc.getAccountType().equals("CHECKING"))) {
                clientAcc = acc;
            }
        }
        return clientAcc;
    }
}
