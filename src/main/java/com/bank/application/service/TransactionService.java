package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.dto.transaction.TransactionDto;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.mapper.transaction.TransactionRequestMapper;
import com.bank.application.model.Account;
import com.bank.application.model.Transaction;
import com.bank.application.repository.AccountRepository;
import com.bank.application.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private TransactionRequestMapper transactionMapper;

    public void create(TransactionDto transaction) {

        transactionRepository.save(transactionMapper.convertToEntity(transaction));
    }

    public List<Transaction> findAllTransactionByAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new NotFoundIdException(
                String.format(ErrorMessages.ACCOUNT_TYPE_WAS_NOT_FOUND_BY_ID, accountId)));
        return transactionRepository.findAllByAccount(account);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.TRANSACTION_WAS_NOT_FOUND_BY_ID, id))
        );
    }

    public boolean update(TransactionDto transaction) {
        if (transactionRepository.existsById(transaction.getId())) {
            transactionRepository.save(transactionMapper.convertToEntity(transaction));
            return true;
        }

        return false;
    }

    public boolean delete(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
