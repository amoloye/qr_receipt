package com.example.qr_receipt.entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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

    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    private String lastName;

    @NonNull
    @NotBlank(message = "please input password")
    private String password;

}
