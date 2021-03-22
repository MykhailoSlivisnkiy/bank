package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.mapper.account.AccountResponseMapper;
import com.bank.application.model.Account;
import com.bank.application.model.Transaction;
import com.bank.application.repository.AccountRepository;
import com.bank.application.repository.TransactionRepository;
import com.bank.application.security.entity.UserToken;
import com.bank.application.security.filters.UsernameAndPasswordAuthenticationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    public void create(Transaction transaction) {
        transactionRepository.save(transaction);
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

    public boolean update(Transaction transaction, Long id) {
        if (transactionRepository.existsById(id)) {
            transaction.setId(id);
            transactionRepository.save(transaction);
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
