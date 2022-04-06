package com.example.qr_receipt.controller;


import com.example.qr_receipt.exception.AppUserAlreadyExistsException;
import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class RegistrationController {
    RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<AppUser> createAppUser(AppUser appUser) throws AppUserAlreadyExistsException {
        return  new ResponseEntity<>(registrationService.createAppUser(appUser), HttpStatus.OK);
    }


}
