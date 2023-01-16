package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;

import java.util.List;

public interface AccountListingService {
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, String accountType);
    Account getClientAccount(String clientID, String accountID);
    Account getClientWithdrawAccount(String clientID, String accountID);
}
