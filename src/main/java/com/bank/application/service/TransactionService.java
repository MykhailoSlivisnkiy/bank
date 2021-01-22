package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.model.Transaction;
import com.bank.application.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public void create(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> readAll() {
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
