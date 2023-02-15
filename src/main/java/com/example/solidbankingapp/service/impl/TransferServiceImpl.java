package com.example.solidbankingapp.service.impl;

import com.example.solidbankingapp.DAO.AccountDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {
    private final AccountDAO accountDAO;

    @Autowired
    public TransferServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public String transfer(String myAccountID, String destAccountID) throws AccountNotFoundException {
        Optional<Account> tempDest = accountDAO.findById(destAccountID);
        if (tempDest.isEmpty()) throw new AccountNotFoundException("dest account does not exist!");
        Optional<Account> tempAcc = accountDAO.findById(myAccountID);
        if (tempAcc.isEmpty()) throw new AccountNotFoundException("account does not exist!");
        Account myAcc = tempAcc.get(), destAcc = tempDest.get();
        accountDAO.deleteById(myAccountID);
        accountDAO.deleteById(destAccountID);
        destAcc.setBalance(destAcc.getBalance() + myAcc.getBalance());
        myAcc.setBalance(0);
        accountDAO.save(myAcc);
        accountDAO.save(destAcc);
        return "transfered from " + myAccountID + " to " + destAccountID + " successfully!";
    }
}
