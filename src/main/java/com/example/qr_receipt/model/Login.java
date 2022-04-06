package com.example.qr_receipt.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Login {
    @NotBlank
    private String userName;

    @NotBlank(message = "please input password")
    private String password;
}
