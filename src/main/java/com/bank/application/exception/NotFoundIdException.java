package com.bank.application.exception;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(String message) {
        super(message);
    }
}
