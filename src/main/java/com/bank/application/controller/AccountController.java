package com.bank.application.controller;

import com.bank.application.dto.account.AccountDto;
import com.bank.application.model.Account;
import com.bank.application.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @GetMapping()
    public List<AccountDto> findAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountDto findAccount(@PathVariable("id") Long id) {
        return accountService.findById(id);
    }

    @PostMapping()
    public void createAccount(@RequestBody Account account) {
        accountService.create(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.delete(id);
    }
}
