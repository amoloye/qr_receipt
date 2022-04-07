package com.example.qr_receipt.entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long appUserId;

    @NotBlank(message = "username cannot be blank")
    private String userName;

    @NotBlank(message = "store name cannot be blank")
    private String storeName;

    @NotBlank(message = "please input password")
    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Receipt> receiptList;

}
