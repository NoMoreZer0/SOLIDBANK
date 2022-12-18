package com.example.solidbankingapp;

import com.example.solidbankingapp.CLI.AccountBasicCLI;
import com.example.solidbankingapp.CLI.MyCLI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SolidbankingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SolidbankingApplication.class, args);
    }

    @Override
    public void run(String ...args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        MyCLI cli = (MyCLI)context.getBean("myCLI");
        AccountBasicCLI accountBasicCLI = (AccountBasicCLI)context.getBean("accountBasicCLI");
        String clientID = "1";
        while (true) {
            String line = cli.getScanner().next();
            if (line.equals("1")) {
                accountBasicCLI.getAccounts(clientID);
            }
            else if (line.equals("2")) {
                accountBasicCLI.createAccountRequest(clientID);
                System.out.println("Bank Account Created");
            }
            else if (line.equals("7")) {
                System.out.println("Application Closed");
                break;
            }
            else System.out.println("Undefined Command");
        }
    }
}
