package com.example.solidbankingapp.controller;

import com.example.solidbankingapp.entity.*;
import com.example.solidbankingapp.exception.WithdrawNotAllowedException;
import com.example.solidbankingapp.security.User;
import com.example.solidbankingapp.service.*;
import com.example.solidbankingapp.service.impl.AccountDepositServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountListingService accountListingService;
    private final AccountDepositServiceImpl accountDepositService;
    private final AccountWithdrawService accountWithdrawService;
    private final AccountCreationService accountCreationService;
    private final AccountDeletionService accountDeletionService;
    private final TransactionService transactionService;
    private final TransferService transferService;

    @Autowired
    public AccountController(AccountListingService accountListingService, AccountDepositServiceImpl accountDepositService, AccountWithdrawService accountWithdrawService, AccountCreationService accountCreationService, AccountDeletionService accountDeletionService, TransactionService transactionService, TransferService transferService) {
        this.accountListingService = accountListingService;
        this.accountDepositService = accountDepositService;
        this.accountWithdrawService = accountWithdrawService;
        this.accountCreationService = accountCreationService;
        this.accountDeletionService = accountDeletionService;
        this.transactionService = transactionService;
        this.transferService = transferService;
    }

    @GetMapping
    public List<Account> listAccounts() {
        return accountListingService.getClientAccounts(getClientId());
    }

    @PostMapping
    public String createAccount(@RequestBody AccountTypeRequest accountTypeRequest) {
        return accountCreationService.createNewAccount(accountTypeRequest.getType(), getClientId());
    }

    @GetMapping("/{accountID}")
    public ResponseEntity<Object> getAccount(@PathVariable String accountID) {
        if (!isAccountBelongs(accountID)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        }
        return ResponseEntity.ok(accountListingService.getClientAccount(getClientId(), accountID));
    }

    @DeleteMapping("/{accountID}")
    public ResponseEntity<Object> deleteAccount(@PathVariable String accountID) {
        if (!isAccountBelongs(accountID)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        }
        return ResponseEntity.ok(accountDeletionService.delete(accountID));
    }

    @PostMapping("/{accountID}/deposit")
    public ResponseEntity<Object> depositAccount(@PathVariable String accountID, @RequestBody TransactionRequest transactionRequest) {
        if (!isAccountBelongs(accountID)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        }
        try {
            transactionService.add(new Transaction(getClientId(), accountID, transactionRequest.getAmount(), "Deposit", false));
            return ResponseEntity.ok(accountDepositService.deposit(transactionRequest.getAmount(), accountListingService.getClientAccount(getClientId(), accountID)));
        } catch (NullPointerException e) {
            transactionService.add(new Transaction(getClientId(), accountID, transactionRequest.getAmount(), "Deposit", true));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((String)("This account doest not belong to you or not exist!"));
        }
    }

    @PostMapping("/{accountID}/withdraw")
    public ResponseEntity<Object> withdrawAccount(@PathVariable String accountID, @RequestBody TransactionRequest transactionRequest) {
        if (!isAccountBelongs(accountID)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        }
        try {
            transactionService.add(new Transaction(getClientId(), accountID, transactionRequest.getAmount(), "Withdraw", false));
            return ResponseEntity.ok(accountWithdrawService.withdraw(transactionRequest.getAmount(), accountListingService.getClientAccount(getClientId(), accountID)));
        } catch (NullPointerException e) {
            transactionService.add(new Transaction(getClientId(), accountID, transactionRequest.getAmount(), "Withdraw", true));
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        } catch (WithdrawNotAllowedException e) {
            transactionService.add(new Transaction(getClientId(), accountID, transactionRequest.getAmount(), "Withdraw", true));
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)(e.getMessage()));
        }
    }

    @PostMapping("/{accountID}/transfer")
    public ResponseEntity<Object> transferFromAccount(@PathVariable String accountID, @RequestBody TransferRequest transferRequest) {
        if (!isAccountBelongs(accountID)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        }
        String destAccountID = transferRequest.getDestAccountID();
        try {
            return ResponseEntity.ok(transferService.transfer(accountID, destAccountID));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((String)(e.getMessage()));
        }
    }

    @GetMapping("/{accountID}/transactions")
    public ResponseEntity<Object> getTransactionsByID(@PathVariable String accountID) {
        if (!isAccountBelongs(accountID)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body((String)("This account doest not belong to you or not exist!"));
        }
        return ResponseEntity.ok(transactionService.getTransactionByID(getClientId(), accountID));
    }

    private String getClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return Long.toString(user.getId());
    }

    private boolean isAccountBelongs(String accountID) {
        Account acc = accountListingService.getClientAccount(getClientId(), accountID);
        return (acc != null);
    }
}
