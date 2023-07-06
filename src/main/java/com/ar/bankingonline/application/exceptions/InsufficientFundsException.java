package com.ar.bankingonline.application.exceptions;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(String message) {
        super(message);
    }
}
