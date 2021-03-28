package com.bank.application.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {
    private Long id;
    private String accountNumber;
    private String cvv;
    private Integer balance;
    private String currency;
    private Long userId;
    private String accountStatus;
    private String accountType;
    private String openedDate;
}
