package com.bank.application.controller;

import com.bank.application.model.AccountStatus;
import com.bank.application.service.AccountStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-statuses")
@AllArgsConstructor
public class AccountStatusController {
    private AccountStatusService accountStatusService;

    @GetMapping()
    public List<AccountStatus> findAllAccountStatuses(){
        return accountStatusService.findAll();
    }

    @GetMapping("/{id}")
    public AccountStatus findAccountStatus(@PathVariable("id") Long id) {
        return accountStatusService.findById(id);
    }

    @PostMapping()
    public void createAccountStatus(@RequestBody AccountStatus accountStatus) {
        accountStatusService.create(accountStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountStatus(@PathVariable("id") Long id) {
        accountStatusService.delete(id);
    }
}
