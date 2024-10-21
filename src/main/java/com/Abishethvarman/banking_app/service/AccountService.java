package com.Abishethvarman.banking_app.service;

import com.Abishethvarman.banking_app.dto.AccountDto;

import java.util.List;
//import com.Abishethvarman.banking_app.entity.Account;

public interface AccountService {

//    Contains business logic. It acts as an intermediary between the controller and the repository.
//    Account createAccount(Account account);
         AccountDto createAccount(AccountDto accountDto);

         AccountDto getAccountById(Long id);

         List<AccountDto> getAllAccounts();

         AccountDto deposit(Long id, double amount);

         AccountDto withdraw (Long id, double amount);

         void deleteAccount(Long id);

         List<AccountDto> getAccountByNic(Long nic);

         AccountDto editDetailsById(Long id, AccountDto accountDto);

}
