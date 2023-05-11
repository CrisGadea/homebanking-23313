package com.ar.bankingonline.mappers;

import com.ar.bankingonline.models.User;
import com.ar.bankingonline.models.dtos.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    // Los mappers me permiten enviar los datos desde una entidad
    //  hacia un dto o visceversa

    // TODO: Aplicar Patron Builder

    public User dtoToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());

        return user;
    }

    public UserDto dtoMapToDto(User user){
        UserDto dto = new UserDto();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());

        return dto;
    }

}
