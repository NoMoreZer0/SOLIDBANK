package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.TransactionDAO;
import com.example.solidbankingapp.entity.Transaction;
import com.example.solidbankingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {
    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public void add(Transaction transaction) {
        transactionDAO.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionByID(String clientID, String accountID) {
        List<Transaction> transactions = (List<Transaction>) transactionDAO.findAll();
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getClientID().equals(clientID) && transaction.getAccountID().equals(accountID)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }
}
