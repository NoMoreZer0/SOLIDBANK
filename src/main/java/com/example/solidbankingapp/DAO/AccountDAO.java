package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
}
