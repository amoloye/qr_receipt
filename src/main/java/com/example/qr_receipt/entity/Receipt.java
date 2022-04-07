package com.example.qr_receipt.entity;

import lombok.*;

import javax.persistence.*;

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
    private List<Product> productList;

    private  LocalDateTime localDateTime;

    private Double totalPrice;


    public LocalDateTime getLocalDateTime () {
        return localDateTime;
    }

    public void setLocalDateTime (LocalDateTime localDateTime) {
        this.localDateTime = LocalDateTime.now();
    }



    public Double getTotalPrice () {
        return totalPrice;
    }

    public void setTotalPrice (Product totalPrice) {
        this.totalPrice = getProductList().stream()
               .map (Product::getProductPrice)
                .reduce ((double) 0, Double::sum);
    }

}
