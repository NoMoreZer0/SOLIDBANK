package com.example.solidbankingapp.transaction;

import com.example.solidbankingapp.DAO.TransactionDAO;
import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.Transaction;
import com.example.solidbankingapp.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    public void execute(Account account, double amount) {
        if (account == null || amount > account.getBalance()) {
            if (account == null) System.out.println("Account does not exist or not allowed to withdraw");
            else if (amount > account.getBalance()) System.out.println("Insufficient amount of money in account");
            assert account != null;
            transactionDAO.addTransaction(new Transaction(account.getClientID(), account.getId(), amount, "Withdraw", true));
            return;
        }
        transactionDAO.addTransaction(new Transaction(account.getClientID(), account.getId(), amount, "Withdraw", false));
        accountWithdrawService.withdraw(amount, account);
    }

}
