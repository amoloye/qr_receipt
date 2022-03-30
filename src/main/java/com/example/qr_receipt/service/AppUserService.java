package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.AppUser;

public interface AppUserService {
    AppUser createUser (AppUser appUser);

    AppUser fetchUserByFirstName (String firstName);

    AppUser updateUser (Long appUserId, AppUser appUser);

    void deleteAppUserById (Long userId);

    AppUser fetchAppUserById (Long userId) throws Exception;
}
