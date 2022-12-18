package com.example.solidbankingapp.entity;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, String clientID, double balance) {
        super(AccountType.SAVING, id, clientID, balance, true);
    }
}