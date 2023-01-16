package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.exception.WithdrawNotAllowedException;
import com.example.solidbankingapp.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    @Autowired
    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public String withdraw(double amount, Account account) throws NullPointerException, WithdrawNotAllowedException {
        double oldBalance = account.getBalance();
        if (oldBalance < amount) {
            throw new WithdrawNotAllowedException("Insufficient amount of balance");
        }
        double newBalance = oldBalance - amount;
        accountDAO.deleteById(account.getId());
        account.setBalance(newBalance);
        accountDAO.save(account);
        return amount + "$ transferred from " + account.getId() + " account";
    }
}
