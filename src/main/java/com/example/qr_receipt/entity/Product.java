package com.example.qr_receipt.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class Product {

    public Product (String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long productId;

    @NotBlank(message = "product name cannot be blank")
    private String productName;


    @NotNull(message = "specify price in euros")
    private double unitPrice;



    @Transient
    @NotNull(message = "specify quantity")
    @Min(1)
    private int quantity;

    @Transient
    private double TotalAmount = getTotalAmount();


    public double getTotalAmount (){
        return quantity * unitPrice;
    }


}
