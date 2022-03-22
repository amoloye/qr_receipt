package com.example.qr_receipt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //buyer
    @OneToOne
    @JoinColumn
    private AppUser appUser;


    @OneToMany
    @JoinColumn
    private List<Product> productList;

    private int quantity;


}
