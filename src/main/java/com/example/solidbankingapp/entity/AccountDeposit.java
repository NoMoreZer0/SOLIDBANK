package com.example.solidbankingapp.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountDeposit extends Account {
    public AccountDeposit(String accountType, String accountID, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, accountID, clientID, balance, withdrawAllowed);
    }
}
