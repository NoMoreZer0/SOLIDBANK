package com.example.solidbankingapp.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, String clientID, double balance) {
        super("SAVING", id, clientID, balance, true);
    }
}
