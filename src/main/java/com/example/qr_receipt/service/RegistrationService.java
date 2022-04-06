package com.example.qr_receipt.service;

import com.example.qr_receipt.exception.AppUserAlreadyExistsException;
import com.example.qr_receipt.entity.AppUser;

public interface RegistrationService {
    AppUser createAppUser(AppUser appUser) throws AppUserAlreadyExistsException;
}
