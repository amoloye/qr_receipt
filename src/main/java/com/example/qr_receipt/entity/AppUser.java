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

    @NotBlank
    private String userName;

    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    private String lastName;

    @NotBlank(message = "please input password")
    private String password;

    @OneToMany
    @JoinColumn
    private List<StoreDetail> storeDetailList;

}
