package com.currencyConverter.converter.exceptions;

public class CurrencyNotSupportedException extends RuntimeException {

    public CurrencyNotSupportedException(String message) {
        super(message);
    }
}
