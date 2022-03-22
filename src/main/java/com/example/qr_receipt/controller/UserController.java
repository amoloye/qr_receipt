package com.example.qr_receipt.controller;

import com.example.qr_receipt.entity.AppUser;
import com.example.qr_receipt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public AppUser createUser (@RequestBody AppUser appUser){
        return userService.createUser(appUser);
    }

    @GetMapping("/user/{name}")
    public AppUser fetchUserByFirstName(@PathVariable("name") String firstName){
        return userService.fetchUserByFirstName(firstName);
    }

}
