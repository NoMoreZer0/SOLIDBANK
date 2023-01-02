package com.example.solidbankingapp.CLI;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();
    String requestClientAccountNumber();
}
