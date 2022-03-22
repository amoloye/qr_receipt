package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.Product;
import com.example.qr_receipt.repository.ProductRepository;
import com.example.qr_receipt.service.ProductService;
import com.google.zxing.BarcodeFormat;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;



    @Override
    public void createProduct (Product product) {
         productRepository.save(product);
    }

    @Override
    public void createProductList (List<Product> productList) {
        productRepository.saveAll(productList);

    }

    @Override
    public Product fetchProductByName (String productName) {
        return productRepository.findByProductNameIgnoreCase(productName);
    }

    @Override
    public List<Product> fetchProductList () {
        return productRepository.findAll();
    }



//    @Override
//    public String writeQRCode (String productName) throws Exception {
//        String QRCODE_PATH= "src/main/java/com/example/qr_receipt/QRCODE_SERVER";
//        Product product = productRepository.findByProductNameIgnoreCase(productName);
//        String qrcode= QRCODE_PATH+ product.getProductName() + "-QRCODE.png";
//
//        QRCodeWriter writer = new QRCodeWriter();
//        BitMatrix bitMatrix = writer.encode(product.getProductName()+
//                "\n"+ product.getPrice()+ "\n"+ product.getQuantity(), BarcodeFormat.QR_CODE,350,350);
//
//        Path path = FileSystems.getDefault().getPath(qrcode);
//        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
//        return "QRCODE is generated successfully";
//    }








}
