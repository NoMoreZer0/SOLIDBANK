package com.example.solidbankingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String clientID;
    @Id
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
