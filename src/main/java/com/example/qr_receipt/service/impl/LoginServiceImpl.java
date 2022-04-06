package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.exception.UserDoesNotExistException;
import com.example.qr_receipt.model.Login;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final AppUserRepository appUserRepository;

    private  final Login login;


    @Override
    public String fetchAppUserByUsernameAndPassword (String username, String password)
            throws UserDoesNotExistException {
        AppUser appUserDB= appUserRepository.findByUserNameAndPassword(login.getUserName(),login.getPassword());
        if (!Objects.equals(appUserDB.getUserName(), login.getUserName())
                && !Objects.equals(appUserDB.getPassword(), login.getPassword())){
            throw new UserDoesNotExistException("This user does not exist");
        }
        return appUserDB.getUserName() + " Logged in successfully";

    }
}
