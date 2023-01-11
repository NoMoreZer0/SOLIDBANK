package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositServiceImpl implements AccountDepositService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        double oldBalance = account.getBalance();
        double newBalance = amount + oldBalance;
        accountDAO.deleteById(account.getId());
        account.setBalance(newBalance);
        accountDAO.save(account);
        System.out.println(amount + "$ transferred to " + account.getId() + " account");
    }
}
