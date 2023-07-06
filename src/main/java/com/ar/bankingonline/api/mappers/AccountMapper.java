package com.ar.bankingonline.api.mappers;

import com.ar.bankingonline.api.dtos.AccountDto;
import com.ar.bankingonline.domain.models.Account;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public Account dtoToAccount(AccountDto dto){
        Account account = new Account();
        account.setBalance(dto.getAmount());
        account.setNumber(dto.getNumber());
        //account.setOwner(dto.getOwner());
        return account;
    }

    public AccountDto AccountToDto(Account account){
        AccountDto dto = new AccountDto();
        dto.setAmount(account.getBalance());
        dto.setNumber(account.getNumber());
        //dto.setOwner(account.getOwner());
        dto.setId(account.getId());
        return dto;
    }
}
