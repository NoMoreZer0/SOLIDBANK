package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountDAO extends CrudRepository <Account, String> {
}
