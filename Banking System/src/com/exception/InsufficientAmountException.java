package com.exception;

@SuppressWarnings("serial")
public class InsufficientAmountException extends Exception {
    public InsufficientAmountException(String message) {
        super(message);
    }
}
