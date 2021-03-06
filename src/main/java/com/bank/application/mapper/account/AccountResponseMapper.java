package com.bank.application.mapper.account;

import com.bank.application.dto.account.AccountDto;
import com.bank.application.mapper.Mapper;
import com.bank.application.model.Account;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountResponseMapper implements Mapper<Account, AccountDto> {
    private ModelMapper modelMapper;

    @Override
    public AccountDto convertToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public Account convertToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }
}
