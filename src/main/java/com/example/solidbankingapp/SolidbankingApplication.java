package com.example.solidbankingapp;

import com.example.solidbankingapp.CLI.AccountBasicCLI;
import com.example.solidbankingapp.CLI.MyCLI;
import com.example.solidbankingapp.CLI.TransactionDepositCLI;
import com.example.solidbankingapp.CLI.TransactionWithdrawCLI;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@SecurityScheme(name = "basicauth", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, bearerFormat = "JWT")
public class SolidbankingApplication {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SolidbankingApplication.class, args);
    }
}
