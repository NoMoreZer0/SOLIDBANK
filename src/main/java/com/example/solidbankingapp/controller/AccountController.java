package com.example.solidbankingapp.controller;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.AccountTypeRequest;
import com.example.solidbankingapp.entity.Transaction;
import com.example.solidbankingapp.entity.TransactionRequest;
import com.example.solidbankingapp.exception.WithdrawNotAllowedException;
import com.example.solidbankingapp.service.*;
import com.example.solidbankingapp.service.impl.AccountDepositServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountListingService accountListingService;
    private AccountDepositServiceImpl accountDepositService;
    private AccountWithdrawService accountWithdrawService;
    private AccountCreationService accountCreationService;
    private AccountDeletionService accountDeletionService;
    private TransactionService transactionService;

    @Autowired
    public AccountController(AccountListingService accountListingService, AccountDepositServiceImpl accountDepositService, AccountWithdrawService accountWithdrawService, AccountCreationService accountCreationService, AccountDeletionService accountDeletionService, TransactionService transactionService) {
        this.accountListingService = accountListingService;
        this.accountDepositService = accountDepositService;
        this.accountWithdrawService = accountWithdrawService;
        this.accountCreationService = accountCreationService;
        this.accountDeletionService = accountDeletionService;
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Account> listAccounts() {
        return accountListingService.getClientAccounts("1");
    }

    @PostMapping
    public String createAccount(@RequestBody AccountTypeRequest accountTypeRequest) {
        return accountCreationService.createNewAccount(accountTypeRequest.getType(), "1");
    }

    @GetMapping("/{accountID}")
    public Account getAccount(@PathVariable String accountID) {
        return accountListingService.getClientAccount("1", accountID);
    }

    @DeleteMapping("/{accountID}")
    public String deleteAccount(@PathVariable String accountID) {
        return accountDeletionService.delete(accountID);
    }

    @PostMapping("/{accountID}/deposit")
    public String depositAccount(@PathVariable String accountID, @RequestBody TransactionRequest transactionRequest) {
        try {
            transactionService.add(new Transaction("1", accountID, transactionRequest.getAmount(), "Deposit", false));
            return accountDepositService.deposit(transactionRequest.getAmount(), accountListingService.getClientAccount("1", accountID));
        } catch (NullPointerException e) {
            transactionService.add(new Transaction("1", accountID, transactionRequest.getAmount(), "Deposit", true));
            return "Account does not exist";
        }
    }

    @PostMapping("/{accountID}/withdraw")
    public String withdrawAccount(@PathVariable String accountID, @RequestBody TransactionRequest transactionRequest) {
        try {
            transactionService.add(new Transaction("1", accountID, transactionRequest.getAmount(), "Withdraw", false));
            return accountWithdrawService.withdraw(transactionRequest.getAmount(), accountListingService.getClientAccount("1", accountID));
        } catch (NullPointerException e) {
            transactionService.add(new Transaction("1", accountID, transactionRequest.getAmount(), "Withdraw", true));
            return "Account does not exist";
        } catch (WithdrawNotAllowedException e) {
            transactionService.add(new Transaction("1", accountID, transactionRequest.getAmount(), "Withdraw", true));
            return e.getMessage();
        }
    }

    @GetMapping("/{accountID}/transactions")
    public List<Transaction> getTransactionsByID(@PathVariable String accountID) {
        return transactionService.getTransactionByID(accountID);
    }
}
