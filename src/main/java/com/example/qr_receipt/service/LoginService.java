package com.example.qr_receipt.service;

import com.example.qr_receipt.exception.InputLoginFieldException;
import com.example.qr_receipt.exception.UserDoesNotExistException;
import com.example.qr_receipt.model.Login;

public interface LoginService {
    String LoginAppUserByUsernameAndPassword (Login login) throws UserDoesNotExistException, InputLoginFieldException;


}
