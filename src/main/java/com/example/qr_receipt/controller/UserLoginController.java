package com.example.qr_receipt.controller;
import com.example.qr_receipt.exception.InputLoginFieldException;
import com.example.qr_receipt.exception.UserDoesNotExistException;
import com.example.qr_receipt.model.Login;
import com.example.qr_receipt.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@AllArgsConstructor
@RestController
public class UserLoginController {

    private final LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<String> fetchAppUserByUsernameAndPassword
            (@Valid @RequestBody Login login)
            throws UserDoesNotExistException, InputLoginFieldException {
       return new ResponseEntity<>(loginService.LoginAppUserByUsernameAndPassword(login), HttpStatus.OK);

    }



}
