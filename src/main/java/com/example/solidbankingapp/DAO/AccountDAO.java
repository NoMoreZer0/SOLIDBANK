package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
}
