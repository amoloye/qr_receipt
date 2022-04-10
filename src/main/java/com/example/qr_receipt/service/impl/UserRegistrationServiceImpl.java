package com.example.qr_receipt.service.impl;


import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.exception.AppUserAlreadyExistsException;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserRegistrationServiceImpl implements RegistrationService {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUser createAppUser (AppUser appUser) throws AppUserAlreadyExistsException {
       Optional<AppUser> appUserDB = Optional.ofNullable(appUserRepository.findByStoreName(appUser.getStoreName()));
        if(appUserDB.isPresent()){
            throw new AppUserAlreadyExistsException(appUserDB.get().getUsername() + " is a registered user");
        }
        return appUserRepository.save(appUser);
    }
}
