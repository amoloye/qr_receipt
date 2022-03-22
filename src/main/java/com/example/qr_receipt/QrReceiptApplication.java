package com.example.qr_receipt;

import com.example.qr_receipt.entity.Product;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.FileSystems;
import java.nio.file.Path;

@SpringBootApplication
public class QrReceiptApplication { public static void main (String[] args) {
    SpringApplication.run(QrReceiptApplication.class, args);
}

}
