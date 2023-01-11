package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDAO extends CrudRepository <Transaction, String> {
}
