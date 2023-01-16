package com.example.solidbankingapp.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest {
    private double amount;

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "amount=" + amount +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonCreator
    public TransactionRequest(@JsonProperty("amount") double amount) {
        this.amount = amount;
    }
}
