package com.keith.bank;

public class InsufficientFundsException extends Exception { // checked exception
    public InsufficientFundsException(String message) {
        super(message);
    }
}