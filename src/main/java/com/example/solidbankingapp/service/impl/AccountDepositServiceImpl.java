package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountDepositService;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositServiceImpl implements AccountDepositService {
    @Override
    public void deposit(double amount, Account account) {
        double oldBalance = account.getBalance();
        double newBalance = amount + oldBalance;
        account.setBalance(newBalance);
        System.out.println(amount + "$ transferred to " + account.getId() + " account");
    }
}
