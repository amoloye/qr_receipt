package com.example.qr_receipt.repository;

import com.example.qr_receipt.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   

   Product findByProductNameIgnoreCase (String productName);


    void deleteByProductId (Long productId);
}
