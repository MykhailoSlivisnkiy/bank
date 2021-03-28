package com.bank.application.controller;

import com.bank.application.dto.account.AccountDto;
import com.bank.application.dto.account.AccountRequestDto;
import com.bank.application.model.Account;
import com.bank.application.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@CrossOrigin
public class AccountController {
    private AccountService accountService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDto> findAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Set<AccountDto> findAllAccountsByUser(@PathVariable Long id){
        return accountService.findAllAccountsByUser(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDto findAccount(@PathVariable("id") Long id) {
        return accountService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountRequestDto account) {
        accountService.create(account);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateAccount(@RequestBody AccountRequestDto account) {
        accountService.update(account);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.delete(id);
    }
}
