package com.bank.application.controller;

import com.bank.application.model.AccountType;
import com.bank.application.model.Transaction;
import com.bank.application.service.AccountTypeService;
import com.bank.application.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;

    @GetMapping()
    public List<Transaction> findAllTransactions(){
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Transaction findTransaction(@PathVariable("id") Long id) {
        return transactionService.findById(id);
    }

    @PostMapping()
    public void createTransaction(@RequestBody Transaction transaction) {
        transactionService.create(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") Long id) {
        transactionService.delete(id);
    }
}