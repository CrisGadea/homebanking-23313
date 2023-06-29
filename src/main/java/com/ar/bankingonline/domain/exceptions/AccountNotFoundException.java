package com.ar.bankingonline.domain.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException (String message) {
        super(message);
    }

}
