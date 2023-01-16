package com.example.solidbankingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    private String clientID;
    private String accountID;
    private double amount;
    private String type;
    private boolean failed;

    public Transaction(String clientID, String accountID, double amount, String type, boolean failed) {
        this.clientID = clientID;
        this.accountID = accountID;
        this.amount = amount;
        this.type = type;
        this.failed = failed;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

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
