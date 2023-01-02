package com.example.solidbankingapp.transaction;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;

    public void execute(Account account, double amount) {
        if (amount == 0) {
            System.out.println("Amount can't be 0");
            return;
        }
        accountDepositService.deposit(amount, account);
    }
}
