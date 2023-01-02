package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
