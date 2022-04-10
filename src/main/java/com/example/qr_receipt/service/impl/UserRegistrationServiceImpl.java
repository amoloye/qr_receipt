package com.example.qr_receipt.service.impl;


import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRegistrationServiceImpl implements RegistrationService {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUser createAppUser (AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}
