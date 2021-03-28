package com.bank.application.mapper.account;

import com.bank.application.dto.account.AccountRequestDto;
import com.bank.application.mapper.Mapper;
import com.bank.application.model.Account;
import com.bank.application.model.enums.AccountStatus;
import com.bank.application.model.enums.AccountType;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class AccountRequestMapper implements Mapper<Account, AccountRequestDto>  {
    private ModelMapper modelMapper;

    @Override
    public AccountRequestDto convertToDto(Account account) {
        return modelMapper.map(account, AccountRequestDto.class);
    }

    @Override
    public Account convertToEntity(AccountRequestDto accountRequestDto) {
        Account account = modelMapper.map(accountRequestDto, Account.class);
        account.setAccountStatus(AccountStatus.valueOf(accountRequestDto.getAccountStatus().toUpperCase()));
        account.setAccountType(AccountType.valueOf(accountRequestDto.getAccountType().toUpperCase()));
        account.setOpenedDate(LocalDateTime.parse(accountRequestDto.getOpenedDate()));
        return account;
    }
}
