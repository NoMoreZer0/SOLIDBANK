package com.example.solidbankingapp.CLI;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI {
    private Scanner scanner;

    MyCLI() {
        scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public String requestAccountType(String clientID) {
        System.out.println("Choose account type\n[CHECKING, SAVING, FIXED]");
        String acc = scanner.next();
        if (acc.equals("FIXED") || acc.equals("SAVING") || acc.equals("CHECKING")) return acc;
        return "";
    }

    @Override
    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        String id = this.scanner.next();
        return id;
    }

    @Override
    public double requestClientAmount() {
        System.out.println("Type amount of money");
        double balance = this.scanner.nextDouble();
        return balance;
    }
}
