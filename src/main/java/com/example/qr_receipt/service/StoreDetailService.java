package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.StoreDetail;

public interface StoreDetailService {
    StoreDetail saveStoreDetail (StoreDetail storeDetail);

    StoreDetail fetchStoreDetailById (Long storeId) throws Exception;

    void deleteStoreDetailById (Long storeId);

    StoreDetail updateStoreDetail (Long storeId, StoreDetail storeDetail);
}
