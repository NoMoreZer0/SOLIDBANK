package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, Account account) {
        double oldBalance = account.getBalance();
        double newBalance = oldBalance - amount;
        accountDAO.deleteById(account.getId());
        account.setBalance(newBalance);
        accountDAO.save(account);
        System.out.println(amount + "$ transferred from " + account.getId() + " account");
    }
}
