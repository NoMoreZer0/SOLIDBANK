package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return this.accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        this.accountList.add(account);
    }
}
