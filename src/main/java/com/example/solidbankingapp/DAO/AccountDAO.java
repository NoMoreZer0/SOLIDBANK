package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;
import com.example.solidbankingapp.entity.AccountType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDAO extends CrudRepository <Account, String> {
}
