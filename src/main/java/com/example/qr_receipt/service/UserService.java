package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.AppUser;

public interface UserService {
    AppUser createUser (AppUser appUser);

    AppUser fetchUserByFirstName (String firstName);
}
