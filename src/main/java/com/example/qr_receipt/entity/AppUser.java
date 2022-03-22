package com.example.qr_receipt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String password;




}
