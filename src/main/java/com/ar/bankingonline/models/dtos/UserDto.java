package com.ar.bankingonline.models.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {

    private Integer id;

    private String username;

    private String password;

}