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
public class SolidbankingApplication {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SolidbankingApplication.class, args);
    }
}
