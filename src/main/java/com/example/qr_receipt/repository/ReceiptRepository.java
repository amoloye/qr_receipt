package com.example.qr_receipt.repository;

import com.example.qr_receipt.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
    Receipt findByReceiptId (Long receiptId);


}
