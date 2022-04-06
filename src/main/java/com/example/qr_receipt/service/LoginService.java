package com.example.qr_receipt.service;

import com.example.qr_receipt.exception.UserDoesNotExistException;

public interface LoginService {
    String fetchAppUserByUsernameAndPassword (String username, String password) throws UserDoesNotExistException;
}
