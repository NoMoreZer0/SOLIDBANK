package com.example.solidbankingapp.entity;

public class FixedAccount extends AccountDeposit{
    public FixedAccount(String accountID, String clientID, double balance) {
        super(AccountType.FIXED, accountID, clientID, balance, false);
    }
}
