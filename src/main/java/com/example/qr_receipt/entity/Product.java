package com.example.qr_receipt.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long productId;

    @NotBlank(message = "product name cannot be blank")
    private String productName;

    @NotEmpty(message = "specify quantity")
    private int quantity;

    @NotEmpty(message = "specify price in euros")
    private double unitPrice;

    @Transient
    private double productPrice;

    public double getProductPrice () {
        return productPrice=getUnitPrice() *getQuantity();
    }

    public void setProductPrice (double productPrice) {
        this.productPrice =productPrice;
    }
}
