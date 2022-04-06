package com.example.qr_receipt.repository;

import com.example.qr_receipt.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByFirstName (String firstName);

    AppUser findByUserName (String userName);

    AppUser findByUserNameAndPassword (String userName, String password);
}
