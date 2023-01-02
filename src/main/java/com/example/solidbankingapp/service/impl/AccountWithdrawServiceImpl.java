package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountWithdrawService;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Override
    public void withdraw(double amount, Account account) {
        double oldBalance = account.getBalance();
        double newBalance = oldBalance - amount;
        account.setBalance(newBalance);
        System.out.println(amount + "$ transferred from " + account.getId() + " account");
    }
}
