package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.Receipt;
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



@Service
@AllArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;




    @Override
    public Receipt fetchReceiptById (Long receiptId) {
        return receiptRepository.findByReceiptId(receiptId);
    }

    @Override
    public String generateQRCode (Receipt receipt) throws WriterException, IOException {


        String QRCODE_PATH= "src/main/java/com/example/qr_receipt/QRCODE_SERVER";
        String qrcode= QRCODE_PATH+ receipt.getStoreDetailName().getBusinessName() + "-QRCODE.png";
       QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(receipt.getReceiptId()+ "\n"+receipt.getTotalPrice()
                +receipt.getAppUser().getFirstName()+ "\n" + receipt.getLocalDateTime() + "\n"
                + receipt.getStoreDetailName().getBusinessName()
                + "\n" + receipt.getProductList() , BarcodeFormat.QR_CODE,350,350);
             Path path = FileSystems.getDefault().getPath(qrcode);
             MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
             return "QRCODE is generated successfully";

    }


}


