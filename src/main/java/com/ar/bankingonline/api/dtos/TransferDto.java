package com.ar.bankingonline.api.dtos;

import com.ar.bankingonline.domain.models.Account;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransferDto {

    private Long id;

    private Account origin;

    private Account target;

    private Date date;

    private BigDecimal amount;
}
