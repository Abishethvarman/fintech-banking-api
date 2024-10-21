package com.Abishethvarman.banking_app.controller;

import com.Abishethvarman.banking_app.dto.AccountDto;
import com.Abishethvarman.banking_app.service.AccountService;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //test account controller
    @GetMapping("/test_endpoint")
    public String testAccountController() {
        return "Its running on the port 8080 and the endpoint /api/accounts";
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //GET Account by ID REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //GET all Accounts REST API
    @GetMapping("/accountList")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Delete By ID REST API
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }

    //GET Account by NIC REST API
    @GetMapping("/nic/{nic}")
    public ResponseEntity<List<AccountDto>> getAccountByNic(@PathVariable Long nic){
        List<AccountDto> accountDto = accountService.getAccountByNic(nic);
        return ResponseEntity.ok(accountDto);
    }

    //Edit Details REST API
    @PutMapping("/{id}/edit")
    public ResponseEntity<AccountDto> editDetailsById(@PathVariable Long id,
                                                      @RequestBody AccountDto accountDto){
        AccountDto updatedAccountDto = accountService.editDetailsById(id, accountDto);
        return ResponseEntity.ok(updatedAccountDto);
    }
}
