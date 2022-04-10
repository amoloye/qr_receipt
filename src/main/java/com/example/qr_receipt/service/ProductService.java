package com.example.qr_receipt.service;

import com.example.qr_receipt.entity.Product;

import java.util.List;

public interface ProductService {




    List<Product> fetchProductList ();

    Product fetchProductByName (String productName);

    Product fetchProductById (Long productId) throws Exception;

    void createProductList (List<Product> productList);

    Product updateProduct (String productName, Product product);

    void deleteProductById (Long productId);
}
