package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.exception.UserDoesNotExistException;
import com.example.qr_receipt.model.Login;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final AppUserRepository appUserRepository;

    @Override
    public String LoginAppUserByUsernameAndPassword (Login login)
            throws UserDoesNotExistException{
        String username = login.getUsername();
        String password = login.getPassword();
            Optional<AppUser> appUserDB =
                    Optional.ofNullable(appUserRepository.findByUsernameAndPasswordIgnoreCase(username, password));
            if (appUserDB.isEmpty()){
                throw new UserDoesNotExistException("wrong username or password");
            }



            return appUserDB.get().getUsername() + " Logged in successfully";



    }



}
