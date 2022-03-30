package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository userRepository;

   private static final String AppUserNotFoundException = "User is not found";

    @Override
    public AppUser createUser (AppUser appUser) {

        return userRepository.save(appUser);
    }

    @Override
    public AppUser fetchUserByFirstName (String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public AppUser updateUser (Long appUserId, AppUser appUser) {
        AppUser userDB = userRepository.findById(appUserId).get();

        if (Objects.nonNull(appUser.getFirstName())&&
                !"".equalsIgnoreCase(appUser.getFirstName())){
            userDB.setFirstName(appUser.getFirstName());
        }
        if (Objects.nonNull(appUser.getLastName())&&
                !"".equalsIgnoreCase(appUser.getLastName())){
            userDB.setLastName(appUser.getLastName());
        }

            userDB.setPassword(appUser.getPassword());


        return userRepository.save(userDB);
    }

    @Override
    public void deleteAppUserById (Long userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public AppUser fetchAppUserById (Long userId) throws Exception {
        Optional<AppUser> appUser=userRepository.findById(userId);
        if(appUser.isEmpty()){
            throw new Exception(AppUserNotFoundException);
        }
        return appUser.get();

    }
}
