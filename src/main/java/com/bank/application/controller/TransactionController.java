package com.bank.application.controller;

import com.bank.application.dto.transaction.TransactionDto;
import com.bank.application.model.Transaction;
import com.bank.application.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
@CrossOrigin
public class TransactionController {
    private TransactionService transactionService;

    @GetMapping()
    public List<Transaction> findAllTransactions(){
        return transactionService.findAll();
    }

    @GetMapping("/account/{id}")
    public List<Transaction> findAllTransactionsByAccount(@PathVariable Long id){
        return transactionService.findAllTransactionByAccount(id);
    }

    @GetMapping("/{id}")
    public Transaction findTransaction(@PathVariable("id") Long id) {
        return transactionService.findById(id);
    }

    @PostMapping()
    public void createTransaction(@RequestBody TransactionDto transaction) {
        transactionService.create(transaction);
    }

    @PutMapping()
    public void updateTransaction(@RequestBody TransactionDto transaction) {
        transactionService.update(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") Long id) {
        transactionService.delete(id);
    }
}
