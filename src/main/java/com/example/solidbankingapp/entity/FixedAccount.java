package com.example.solidbankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class FixedAccount extends AccountDeposit {
    public FixedAccount(String accountID, String clientID, double balance) {
        super(AccountType.FIXED, accountID, clientID, balance, false);
    }
}
