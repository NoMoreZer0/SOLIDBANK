package com.example.solidbankingapp.transaction;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;

    public void execute(Account account, double amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient amount of money in account");
            return;
        }
        accountWithdrawService.withdraw(amount, account);
    }

}
