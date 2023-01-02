package com.example.solidbankingapp.transaction;

import com.example.solidbankingapp.DAO.TransactionDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.Transaction;
import com.example.solidbankingapp.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public void execute(Account account, double amount) {
        if (amount == 0 || account == null) {
            if (amount == 0) System.out.println("Amount can't be 0");
            else System.out.println("Account does not exist");
            assert account != null;
            transactionDAO.addTransaction(new Transaction(account.getClientID(), account.getId(), amount, "Deposit", true));
            return;
        }
        transactionDAO.addTransaction(new Transaction(account.getClientID(), account.getId(), amount, "Deposit", false));
        accountDepositService.deposit(amount, account);
    }
}
