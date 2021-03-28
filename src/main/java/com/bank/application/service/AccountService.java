package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.dto.account.AccountDto;
import com.bank.application.dto.account.AccountRequestDto;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.mapper.account.AccountRequestMapper;
import com.bank.application.mapper.account.AccountResponseMapper;
import com.bank.application.model.Account;
import com.bank.application.model.User;
import com.bank.application.model.enums.AccountStatus;
import com.bank.application.model.enums.AccountType;
import com.bank.application.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private AccountResponseMapper responseMapper;
    private AccountRequestMapper requestMapper;
    private UserService userService;

    public void create(AccountRequestDto accountDto) {
        Account account = requestMapper.convertToEntity(accountDto);
        account.setUser(userService.findById(accountDto.getUserId()));

        accountRepository.save(account);
    }

    public List<AccountDto> findAll() {
        return accountRepository.findAll().stream()
                .map(account -> responseMapper.convertToDto(account))
                .collect(Collectors.toList());
    }

    public Set<AccountDto> findAllAccountsByUser(Long userId) {
        User user = userService.findById(userId);
        return accountRepository.findAllByUser(user).stream()
                .map(account -> responseMapper.convertToDto(account))
                .collect(Collectors.toSet());
    }

    public AccountDto findById(Long id) {
        return responseMapper.convertToDto(accountRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.ACCOUNT_WAS_NOT_FOUND_BY_ID, id))));
    }

    public Boolean update(AccountRequestDto accountDto) {
        if(accountRepository.existsById(accountDto.getId())) {
            Account account = requestMapper.convertToEntity(accountDto);
            account.setUser(userService.findById(accountDto.getUserId()));
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
