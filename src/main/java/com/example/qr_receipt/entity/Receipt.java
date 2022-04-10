package com.example.qr_receipt.entity;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Receipt {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long receiptId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private AppUser appUser;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "add at least one product")
    private List<Product> productList;

    private  LocalDateTime localDateTime=getLocalDateTime();

    private Double total;


    public LocalDateTime getLocalDateTime () {
        return LocalDateTime.now();
    }




}
