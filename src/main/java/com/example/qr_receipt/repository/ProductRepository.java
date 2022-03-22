package com.example.qr_receipt.repository;

import com.example.qr_receipt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product,Long> {

   Product findByProductNameIgnoreCase (String productName);
}
