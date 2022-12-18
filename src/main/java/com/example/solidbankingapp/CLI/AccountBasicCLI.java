package com.example.solidbankingapp.CLI;

import com.example.solidbankingapp.BankCore;
import com.example.solidbankingapp.service.AccountListingService;
import com.example.solidbankingapp.service.impl.AccountListingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListingService;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListingService) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListingService = accountListingService;
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListingService.getClientAccounts(clientID));
    }

    public void createAccountRequest(String clientID) {
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(clientID), clientID);
    }
}
