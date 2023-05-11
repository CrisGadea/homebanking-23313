package com.ar.bankingonline.models.dtos;

import lombok.*;

@Data
public class UserDto {

    public UserDto(){}

    private Integer id;

    private String username;

    private String password;

}