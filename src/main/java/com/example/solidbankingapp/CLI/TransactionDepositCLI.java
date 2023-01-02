package com.example.solidbankingapp.CLI;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountListingService;
import com.example.solidbankingapp.transaction.TransactionDeposit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public void depositMoney(String clientID) {
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        Account acc = accountListingService.getClientAccount(clientID, accountID);
        transactionDeposit.execute(acc, amount);
    }
}
