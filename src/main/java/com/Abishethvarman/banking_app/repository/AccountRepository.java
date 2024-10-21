package com.Abishethvarman.banking_app.repository;

import com.Abishethvarman.banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    //The repository interface in Spring Data JPA provides a set of standard CRUD
    List<Account> findByNic(Long nic);
}
