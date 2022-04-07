package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.Product;
import com.example.qr_receipt.entity.Receipt;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;


public interface ReceiptService {

    Receipt fetchReceiptById (Long receiptId);

    String generateQRCode(Receipt receipt)
            throws WriterException, IOException;
}
