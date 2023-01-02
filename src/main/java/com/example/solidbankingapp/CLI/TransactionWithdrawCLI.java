package com.example.solidbankingapp.CLI;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountListingService;
import com.example.solidbankingapp.transaction.TransactionWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@AllArgsConstructor
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public void withdrawMoney(String clientID) {
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        Account acc = accountListingService.getClientWithdrawAccount(clientID, accountID);
        if (acc == null) {
            System.out.println("Account does not exist or not allowed to withdraw");
            return;
        }
        transactionWithdraw.execute(acc, amount);
    }
}
