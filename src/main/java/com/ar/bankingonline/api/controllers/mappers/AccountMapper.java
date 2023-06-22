package com.ar.bankingonline.api.controllers.mappers;

import com.ar.bankingonline.api.controllers.dtos.AccountDto;
import com.ar.bankingonline.domain.models.Account;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public Account dtoToAccount(AccountDto dto){
        Account account = new Account();
        account.setAmount(dto.getAmount());
        account.setNumber(dto.getNumber());
        return account;
    }

    public AccountDto AccountToDto(Account account){
        AccountDto dto = new AccountDto();
        dto.setAmount(account.getAmount());
        dto.setNumber(account.getNumber());
        dto.setId(account.getId());
        return dto;
    }
}
