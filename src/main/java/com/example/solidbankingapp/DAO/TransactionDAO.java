package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getTransaction();
    void addTransaction(Transaction transaction);
}
