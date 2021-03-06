package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.dto.account.AccountDto;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.mapper.account.AccountResponseMapper;
import com.bank.application.model.Account;
import com.bank.application.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private AccountResponseMapper mapper;

    public void create(Account account) {
        accountRepository.save(account);
    }

    public List<AccountDto> findAll() {
        return accountRepository.findAll().stream()
                .map(account -> mapper.convertToDto(account))
                .collect(Collectors.toList());
    }

    public AccountDto findById(Long id) {
        return mapper.convertToDto(accountRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.ACCOUNT_WAS_NOT_FOUND_BY_ID, id))));
    }

    public Boolean update(Account account, Long id) {
        if(accountRepository.existsById(id)) {
            account.setId(id);
            accountRepository.save(account);
            return true;
        }

        return false;
    }

    public void delete(Long id) {
        if(accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        }
    }
}
