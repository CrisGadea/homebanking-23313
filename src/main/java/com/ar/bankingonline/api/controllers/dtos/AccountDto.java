package com.ar.bankingonline.api.controllers.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private int number;
    private BigDecimal amount;
}
