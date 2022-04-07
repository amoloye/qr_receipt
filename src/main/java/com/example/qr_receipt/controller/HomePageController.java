package com.example.qr_receipt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomePageController {

    @GetMapping("/homePage")
    public String homePage(){
        return  "welcome to home page";
    }
}
