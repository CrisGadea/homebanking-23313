package com.ar.bankingonline.api.mappers;

import com.ar.bankingonline.api.dtos.AccountDto;
import com.ar.bankingonline.domain.models.Account;
import com.ar.bankingonline.domain.models.User;
import com.ar.bankingonline.api.dtos.UserDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class UserMapper {

    // Los mappers me permiten enviar los datos desde una entidad
    //  hacia un dto o visceversa

    // TODO: Aplicar Patron Builder

    public User dtoToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        List<Account> accounts = new ArrayList<>();
        if (dto.getAccounts() != null) { // Verifica que la lista de cuentas no sea null
            for (AccountDto accountDto : dto.getAccounts()) {
                Account account = AccountMapper.dtoToAccount(accountDto);
                //account.setOwner(user);
                accounts.add(account);
            }
        }
        user.setAccounts(accounts);

        return user;
    }

    public UserDto userMapToDto(User user){
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        //TODO: modificar getAccounts para obtener mediante el Mapper lista de dtos
        //dto.setAccounts(user.getAccounts());
        dto.setId(user.getId());
        return dto;
    }

}
