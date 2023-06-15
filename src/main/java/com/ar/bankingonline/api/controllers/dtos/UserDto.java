package com.ar.bankingonline.api.controllers.dtos;

import lombok.*;

@Data
public class UserDto {

    public UserDto(){}

    private Integer id;

    private String username;

    private String password;

}