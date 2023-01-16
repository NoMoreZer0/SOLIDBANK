package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;

public interface AccountDepositService {
    String deposit(double amount, Account account);
}
