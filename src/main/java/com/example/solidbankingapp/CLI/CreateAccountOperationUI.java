package com.example.solidbankingapp.CLI;

import com.example.solidbankingapp.entity.AccountType;
import org.springframework.stereotype.Component;

public interface CreateAccountOperationUI {
    String requestAccountType(String clientID);
}
