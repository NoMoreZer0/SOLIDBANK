package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.AccountType;
import com.example.solidbankingapp.service.AccountListingService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {

        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }
}
