package com.example.solidbankingapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountType;
    @Id
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + id + '\'' +
                ", clientID='" + clientID + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }
}
