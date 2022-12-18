package com.example.solidbankingapp.entity;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String accountID, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, accountID, clientID, balance, withdrawAllowed);
    }
}
