package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Transaction;

import java.util.List;

public interface TransactionService {
    void add(Transaction transaction);
    List<Transaction> getTransactionByID(String clientID, String accountID);
}
