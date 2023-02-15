package com.example.solidbankingapp.DAO;

import com.example.solidbankingapp.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, String> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
