package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.AccountType;
import com.example.solidbankingapp.entity.AccountWithdraw;
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

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> res = new ArrayList<>();
        for (Account acc : accountList) {
            if (acc.getAccountType().equals(accountType) && acc.getClientID().equals(clientID)) {
                res.add(acc);
            }
        }
        if (res.isEmpty()) return null;
        return res;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for (Account acc : accountList) {
            if (acc.getClientID().equals(clientID) && acc.getId().equals(accountID)) {
                return acc;
            }
        }
        return null;
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        for (Account acc : accountList) {
            if (acc.getClientID().equals(clientID) && acc.getId().equals(accountID)) {
                if (acc.getAccountType().equals(AccountType.SAVING) || acc.getAccountType().equals(AccountType.CHECKING)) return acc;
                return null;
            }
        }
        return null;
    }
}
