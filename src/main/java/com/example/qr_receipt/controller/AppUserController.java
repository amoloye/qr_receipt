package com.example.qr_receipt.controller;

import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.service.AppUserService;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AppUserController {
    private final AppUserService userService;

    public AppUserController (AppUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public AppUser createUser (@Valid @RequestBody AppUser appUser){
        return userService.createUser(appUser);
    }

    @GetMapping("/user/{id}")
    public AppUser fetchStoreDetailById(@PathVariable ("id") Long userId) throws Exception {
        return userService.fetchAppUserById(userId);
    }

    @GetMapping("/user/{name}")
    public AppUser fetchUserByFirstName(@PathVariable("name") String firstName){
        return userService.fetchUserByFirstName(firstName);
    }

    @PutMapping("/user/{id}")
    public AppUser updateUser(@Valid @PathVariable("id") Long appUserId,
                                         @RequestBody AppUser appUser){
        return  userService.updateUser(appUserId,appUser);

    }

    @DeleteMapping("/user/{id}")
    public String deleteAppUser(@PathVariable ("id") Long userId ){
        userService.deleteAppUserById(userId);
        return "Deleted Successfully";
    }

}
