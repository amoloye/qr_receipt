package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.exception.AppUserAlreadyExistsException;
import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUser createAppUser (AppUser appUser) throws AppUserAlreadyExistsException {
        AppUser appUserDB= appUserRepository.findByUserName(appUser.getUserName());
        if(appUser==appUserDB){
            throw new AppUserAlreadyExistsException("username with another account already exists");
        }
        return appUserRepository.save(appUser);
    }
}
