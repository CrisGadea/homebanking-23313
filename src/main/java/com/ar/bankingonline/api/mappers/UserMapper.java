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


    public User dtoToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDto userMapToDto(User user){
        UserDto dto = new UserDto();
        List<Long> accountsId=new ArrayList<>();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        if (user.getAccounts()!=null)
            for (Account a:
             user.getAccounts()) {
            Long id= a.getId();
            accountsId.add(id);
        }

        dto.setIdAccounts(accountsId);
        dto.setId(user.getId());
        return dto;
    }

}
