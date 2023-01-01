package com.example.solidbankingapp;

import com.example.solidbankingapp.CLI.AccountBasicCLI;
import com.example.solidbankingapp.CLI.MyCLI;
import org.springframework.beans.factory.annotation.Autowired;
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
        String clientID = "1";
        String opString = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit";
        System.out.println("Welcome to CLI bank service\nEnter the operation number\n" + opString);
        while (true) {
            String line = cli.getScanner().next();
            if (line.equals("1")) {
                accountBasicCLI.getAccounts(clientID);
            }
            else if (line.equals("2")) {
                accountBasicCLI.createAccountRequest(clientID);
            }
            else if (line.equals("6")) {
                System.out.println(opString);
            }
            else if (line.equals("7")) {
                System.out.println("Application Closed");
                break;
            }
            else System.out.println("Undefined Command");
        }
    }
}
