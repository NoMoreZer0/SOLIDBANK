package com.example.solidbankingapp;

import com.example.solidbankingapp.CLI.AccountBasicCLI;
import com.example.solidbankingapp.CLI.MyCLI;
import com.example.solidbankingapp.CLI.TransactionDepositCLI;
import com.example.solidbankingapp.CLI.TransactionWithdrawCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SolidbankingApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SolidbankingApplication.class, args);
    }

    @Override
    public void run(String ...args) {
        MyCLI cli = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
          TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        String clientID = "1";
        String opString = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit";
        System.out.println("Welcome to CLI bank service\nEnter the operation number\n" + opString);
        label:
        while (true) {
            String line = cli.getScanner().next();
            switch (line) {
                case "1":
                    accountBasicCLI.getAccounts(clientID);
                    break;
                case "2":
                    accountBasicCLI.createAccountRequest(clientID);
                    break;
                case "3":
                    transactionDepositCLI.depositMoney(clientID);
                    break;
                case "4":
                    transactionWithdrawCLI.withdrawMoney(clientID);
                    break;
                case "6":
                    System.out.println(opString);
                    break;
                case "7":
                    System.out.println("Application Closed");
                    break label;
                default:
                    System.out.println("Undefined Command");
                    break;
            }
        }
    }
}
