package com.example.qr_receipt.exception;

public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException (String message) {
        super(message);
    }
}
