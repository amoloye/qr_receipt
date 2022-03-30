package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.Product;

import java.util.List;

public interface ProductService {
     void createProduct (Product product);

//     String writeQRCode(String productName) throws  Exception;

    List<Product> fetchProductList ();

    Product fetchProductByName (String productName);

    Product fetchProductById (Long productId) throws Exception;

    void createProductList (List<Product> productList);

    Product updateProduct (Long productId, Product product);

    void deleteProductById (Long productId);
}
