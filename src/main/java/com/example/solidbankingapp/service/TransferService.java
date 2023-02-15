package com.example.solidbankingapp.service;

import javax.security.auth.login.AccountNotFoundException;

public interface TransferService {
    public String transfer(String myAccountID, String destAccountID) throws AccountNotFoundException;
}
