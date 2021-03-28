package com.bank.application.mapper.transaction;

import com.bank.application.dto.transaction.TransactionDto;
import com.bank.application.mapper.Mapper;
import com.bank.application.mapper.account.AccountRequestMapper;
import com.bank.application.mapper.account.AccountResponseMapper;
import com.bank.application.model.Transaction;
import com.bank.application.service.AccountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionRequestMapper implements Mapper<Transaction, TransactionDto> {
    private ModelMapper modelMapper;
    private AccountService accountService;
    private AccountResponseMapper accountResponseMapper;

    @Override
    public TransactionDto convertToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public Transaction convertToEntity(TransactionDto transactionRequestDto) {
        Transaction transaction = modelMapper.map(transactionRequestDto, Transaction.class);
        transaction.setAccount(accountResponseMapper.convertToEntity(accountService.findById(transactionRequestDto.getAccountId())));
        return transaction;
    }
}
