package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.AccountType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    Account getClientAccount(String clientID, String accountID);
    Account getClientWithdrawAccount(String clientID, String accountID);
}
