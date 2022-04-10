package com.example.qr_receipt.advice;


import com.example.qr_receipt.exception.AppUserAlreadyExistsException;
import com.example.qr_receipt.exception.InputLoginFieldException;
import com.example.qr_receipt.exception.UserDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handler(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error-> errorMap.put(error.getField(),
                error.getDefaultMessage()));

        return  errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserDoesNotExistException.class)
    public Map<String,String> loginLogic(UserDoesNotExistException exception){
        Map<String,String> errorMap= new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());

        return  errorMap;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AppUserAlreadyExistsException.class)
    public Map<String,String> registrationLogic(AppUserAlreadyExistsException exception){
        Map<String,String> errorMap= new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());

        return  errorMap;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InputLoginFieldException.class)
    public Map<String,String> registrationLogic(InputLoginFieldException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());

        return errorMap;
    }
}
