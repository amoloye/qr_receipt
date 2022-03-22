package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.repository.UserRepository;
import com.example.qr_receipt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public AppUser createUser (AppUser appUser) {
        return userRepository.save(appUser);
    }

    @Override
    public AppUser fetchUserByFirstName (String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
