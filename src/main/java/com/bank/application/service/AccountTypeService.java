package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.model.AccountType;
import com.bank.application.repository.AccountTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountTypeService {
    private AccountTypeRepository accountTypeRepository;

    public void create(AccountType accountType) {
        accountTypeRepository.save(accountType);
    }

    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }

    public AccountType findById(Long id) {
        return accountTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.ACCOUNT_TYPE_WAS_NOT_FOUND_BY_ID, id))
        );
    }

    public Boolean update(AccountType accountType, Long id) {
        if(accountTypeRepository.existsById(id)) {
            accountType.setId(id);
            accountTypeRepository.save(accountType);
            return true;
        }

        return false;
    }

    public Boolean delete(Long id) {
        if(accountTypeRepository.existsById(id)) {
            accountTypeRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
