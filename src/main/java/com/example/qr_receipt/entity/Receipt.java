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

    //buyer
    @OneToOne
    @JoinColumn
    private AppUser appUser;

//store or seller business name
    @OneToOne
    @JoinColumn
    private StoreDetail storeDetailName;

    @OneToMany
    @JoinColumn
    private List<Product> productList;

    private Double totalPrice;
    private LocalDateTime localDateTime;

    public void setTotalPrice (Double totalPrice) {
        this.totalPrice = productList.stream()
                .map (Product::getProductPrice)
                .reduce ((double) 0, Double::sum);
    }

    public LocalDateTime getLocalDateTime () {
        return localDateTime= LocalDateTime.now();
    }


}
