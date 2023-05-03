package com.ar.bankingonline.mappers;

import com.ar.bankingonline.models.User;
import com.ar.bankingonline.models.dtos.UserDto;

public class UserMapper {

    // Los mappers me permiten enviar los datos desde una entidad
    //  hacia un dto o visceversa

    public UserDto userToDtoMap(User user){
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setId(user.getId());

        return dto;
    }

    public User dtoMapToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());

        return user;
    }

}
