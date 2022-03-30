package com.example.qr_receipt.repository;

import com.example.qr_receipt.entity.StoreDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDetailRepository extends JpaRepository<StoreDetail,Long> {
    void deleteByStoreDetailId (Long storeId);


}
