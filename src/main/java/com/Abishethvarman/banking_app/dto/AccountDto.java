package com.Abishethvarman.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //this anotation helps to create the getter setter easily
@AllArgsConstructor //creates all constructors in the mapper
public class AccountDto {
    private long id;
    private long nic;
    private String accountHolderName;
    private double balance;
}
