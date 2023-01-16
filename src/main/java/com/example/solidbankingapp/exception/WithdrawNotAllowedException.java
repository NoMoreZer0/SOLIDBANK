package com.example.solidbankingapp.exception;

public class WithdrawNotAllowedException extends RuntimeException {
    public WithdrawNotAllowedException(String msg) {
        super(msg);
    }
}
