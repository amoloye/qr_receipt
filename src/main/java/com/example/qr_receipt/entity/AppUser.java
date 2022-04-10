package com.example.qr_receipt.entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class AppUser  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long appUserId;

    @NotBlank(message = "username cannot be blank")
    private String username;

    @NotBlank(message = "store name cannot be blank")
    private String storeName;

    @NotBlank(message = "please input password")
    private String password;




}
