package com.example.qr_receipt.repository;

import com.example.qr_receipt.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUsernameAndPasswordIgnoreCase (String username, String password);
    AppUser findByStoreName(String storeName);
}
