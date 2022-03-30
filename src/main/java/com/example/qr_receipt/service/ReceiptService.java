package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.Receipt;
import com.google.zxing.WriterException;

import java.io.IOException;


public interface ReceiptService {
    Receipt saveReceipt (Receipt receipt) throws Exception;

    Receipt fetchReceiptById (Long receiptId);

    String generateQRCode(Long receiptId) throws WriterException, IOException;
}
