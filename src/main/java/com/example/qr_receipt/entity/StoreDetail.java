package com.example.qr_receipt.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class StoreDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storeDetailId;

    @NotBlank(message = "business name cannot be blank")
    private String businessName;

    @NotBlank(message = "specify store address")
    private String storeAddress;

    @NotBlank(message = "specify city")
    private String city;

    @NotBlank(message = "specify state")
    private String state;

    @NotEmpty(message = "input phone number")
    private String phoneNumber;

}
