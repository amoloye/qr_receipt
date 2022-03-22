package com.example.qr_receipt.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String productName;
    private double price;
    //seller
    @OneToOne
    @JoinColumn
    private AppUser appUser;


}
