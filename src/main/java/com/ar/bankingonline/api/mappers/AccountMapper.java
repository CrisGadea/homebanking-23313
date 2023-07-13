package com.ar.bankingonline.api.mappers;

import com.ar.bankingonline.api.dtos.AccountDto;
import com.ar.bankingonline.api.dtos.UserDto;
import com.ar.bankingonline.domain.models.Account;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public Account dtoToAccount(AccountDto dto){
        Account account = new Account();
        account.setBalance(dto.getAmount());
        return account;
    }

    public AccountDto AccountToDto(Account account){
        AccountDto dto = new AccountDto();
        dto.setAmount(account.getBalance());
        //tiraba nullpointer porque no se le estaba seteando el owner y no se puede mapear un objeto nulo
        if (account.getOwner()!=null){
            UserDto userDto=UserMapper.userMapToDto(account.getOwner());
            dto.setOwner(userDto);
        }

        dto.setId(account.getId());
        return dto;
    }
}
