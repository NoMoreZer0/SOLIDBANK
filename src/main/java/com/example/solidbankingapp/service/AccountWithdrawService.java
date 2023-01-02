package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;

public interface AccountWithdrawService {
    void withdraw(double amount, Account account);
}
