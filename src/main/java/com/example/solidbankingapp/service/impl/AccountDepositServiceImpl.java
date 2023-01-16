package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDAO accountDAO;

    @Autowired
    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public String deposit(double amount, Account account) throws NullPointerException {
        double oldBalance = account.getBalance();
        double newBalance = amount + oldBalance;
        System.out.println(account);
        if (!accountDAO.existsById(account.getId())){
            return "Account does not exist";
        }
        accountDAO.deleteById(account.getId());
        account.setBalance(newBalance);
        accountDAO.save(account);
        return amount + "$ transferred to " + account.getId() + " account";
    }
}
