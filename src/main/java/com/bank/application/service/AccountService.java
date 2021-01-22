package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.model.Account;
import com.bank.application.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public void create(Account account) {
        accountRepository.save(account);
    }

    public List<Account> readAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.ACCOUNT_WAS_NOT_FOUND_BY_ID, id)));
    }

    public Boolean update(Account account, Long id) {
        if(accountRepository.existsById(id)) {
            account.setId(id);
            accountRepository.save(account);
            return true;
        }

        return false;
    }

    public Boolean delete(Long id) {
        if(accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
