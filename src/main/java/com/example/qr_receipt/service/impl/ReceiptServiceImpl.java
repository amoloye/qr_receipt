package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.Product;
import com.example.qr_receipt.entity.Receipt;
import com.example.qr_receipt.repository.AppUserRepository;
import com.example.qr_receipt.repository.ProductRepository;
import com.example.qr_receipt.repository.ReceiptRepository;
import com.example.qr_receipt.service.ReceiptService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final AppUserRepository appUserRepository;
    private final ProductRepository productRepository;



    @Override
    public Receipt fetchReceiptById (Long receiptId) {
        return receiptRepository.findByReceiptId(receiptId);
    }

    @Override
    public String generateQRCode (Receipt receipt)
            throws WriterException, IOException {
          //List<Product> productList = productRepository.findAll();

          LocalDateTime localDateTime = receipt.getLocalDateTime();
          String storeName = receipt.getAppUser().getStoreName();
          List<Product> productList = receipt.getProductList();
          double totalPrice =receipt.getTotalPrice();



        String QRCODE_PATH= "src/main/java/com/example/qr_receipt/QRCODE_SERVER";
        String qrcode= QRCODE_PATH+ storeName + "-QRCODE.png";
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(storeName +
                "\n" +productList+ "\n" + localDateTime + "\n"
                + totalPrice, BarcodeFormat.QR_CODE,350,350);
        Path path = FileSystems.getDefault().getPath(qrcode);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);

        receiptRepository.save(receipt);


        return "QRCODE is generated successfully";

    }

}


