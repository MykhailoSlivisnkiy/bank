package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.model.AccountStatus;
import com.bank.application.repository.AccountStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountStatusService {
    private AccountStatusRepository accountStatusRepository;

    public void create(AccountStatus accountStatus) {
        accountStatusRepository.save(accountStatus);
    }

    public List<AccountStatus> findAll() {
        return accountStatusRepository.findAll();
    }

    public AccountStatus findById(Long id) {
        return accountStatusRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.ACCOUNT_STATUS_WAS_NOT_FOUND_BY_ID, id))
        );
    }

    public Boolean update(AccountStatus accountStatus, Long id) {
        if(accountStatusRepository.existsById(id)) {
            accountStatus.setId(id);
            accountStatusRepository.save(accountStatus);
            return true;
        }

        return false;
    }

    public Boolean delete(Long id) {
        if(accountStatusRepository.existsById(id)) {
            accountStatusRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
