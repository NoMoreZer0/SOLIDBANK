package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryTransactionDAO implements TransactionDAO {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public List<Transaction> getTransaction() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
