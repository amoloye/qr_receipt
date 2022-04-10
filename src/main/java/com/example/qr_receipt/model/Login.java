package com.example.qr_receipt.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Login {

    @NotBlank(message = "please input username")
    private String username;

    @NotBlank(message = "please input password")
    private String password;
}
