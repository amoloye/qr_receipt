package com.example.qr_receipt.controller;

import com.example.qr_receipt.entity.Product;
import com.example.qr_receipt.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public void createProduct(@RequestBody Product product){
         productService.createProduct(product);

    }
    @PostMapping("/products")
    public void createProductList(@RequestBody List<Product> productList){
        productService.createProductList(productList);
    }

    @GetMapping("/product/{name}")
    public Product fetchProductByName(@PathVariable("name") String productName){
        return productService.fetchProductByName(productName);
    }

    @GetMapping("/products")
    public List<Product> fetchProductList(){
        return productService.fetchProductList();
    }


}
