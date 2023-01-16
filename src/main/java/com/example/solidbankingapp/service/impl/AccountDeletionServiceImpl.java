package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.service.AccountDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDeletionServiceImpl implements AccountDeletionService {
    private AccountDAO accountDAO;

    @Override
    public String delete(String accountID) {
        if (accountDAO.existsById(accountID)) {
            accountDAO.deleteById(accountID);
            return "Account deleted";
        }
        return "Account not found";
    }

    @Autowired
    public AccountDeletionServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
