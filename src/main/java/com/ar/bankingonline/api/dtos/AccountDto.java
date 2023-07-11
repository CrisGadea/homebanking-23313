package com.ar.bankingonline.api.dtos;

import com.ar.bankingonline.domain.models.User;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private BigDecimal amount;
    private UserDto owner;
}
