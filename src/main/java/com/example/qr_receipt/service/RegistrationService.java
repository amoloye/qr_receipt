package com.example.qr_receipt.service;


import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.exception.AppUserAlreadyExistsException;

public interface RegistrationService {
    AppUser createAppUser(AppUser appUser) throws AppUserAlreadyExistsException;
}
