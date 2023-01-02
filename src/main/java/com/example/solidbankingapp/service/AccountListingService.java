package com.example.solidbankingapp.service;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.AccountType;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AccountListingService {
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    Account getClientAccount(String clientID, String accountID);
    Account getClientWithdrawAccount(String clientID, String accountID);
}
