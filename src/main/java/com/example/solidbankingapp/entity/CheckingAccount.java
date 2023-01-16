package com.example.solidbankingapp.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(String id, String clientID, double balance) {
        super("CHECKING", id, clientID, balance, true);
    }
}
