package com.example.qr_receipt.entity;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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

    @NotNull(message = "specify quantity")
    @Min(1)
    private int quantity;

    @NotEmpty(message = "specify price in euros")
    private double unitPrice;

    @Transient
    private double productPrice;

    public void setProductPrice (double productPrice) {
        this.productPrice =getUnitPrice() *getQuantity();
    }
}
