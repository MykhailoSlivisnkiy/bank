package com.bank.application.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String accountNumber;
    private String cvv;
    private Integer balance;
    private String currency;
}
