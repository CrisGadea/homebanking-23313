package com.ar.bankingonline.api.controllers.mappers;

import com.ar.bankingonline.domain.models.User;
import com.ar.bankingonline.api.controllers.dtos.UserDto;
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
        return user;
    }

    public UserDto userMapToDto(User user){
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setId(user.getId());
        return dto;
    }

}
