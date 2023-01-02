package com.example.solidbankingapp.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Transaction {
    private String clientID;
    private String accountID;
    private double amount;
    private String type;
    private boolean failed;

    @Override
    public String toString() {
        return "Transaction{" +
                "clientID='" + clientID + '\'' +
                ", accountID='" + accountID + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", failed=" + failed +
                '}';
    }
}
