package com.bank.application.controller;

import com.bank.application.model.AccountStatus;
import com.bank.application.model.AccountType;
import com.bank.application.service.AccountStatusService;
import com.bank.application.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-types")
@AllArgsConstructor
public class AccountTypeController {
    private AccountTypeService accountTypeService;

    @GetMapping()
    public List<AccountType> findAllAccountTypes(){
        return accountTypeService.findAll();
    }

    @GetMapping("/{id}")
    public AccountType findAccountType(@PathVariable("id") Long id) {
        return accountTypeService.findById(id);
    }

    @PostMapping()
    public void createAccountType(@RequestBody AccountType accountType) {
        accountTypeService.create(accountType);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountType(@PathVariable("id") Long id) {
        accountTypeService.delete(id);
    }
}
