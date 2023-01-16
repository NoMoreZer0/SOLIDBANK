package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;

public interface AccountWithdrawService {
    String withdraw(double amount, Account account);
}
