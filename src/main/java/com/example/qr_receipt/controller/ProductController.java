package com.example.qr_receipt.controller;

import com.example.qr_receipt.entity.Product;
import com.example.qr_receipt.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;


    @PostMapping("/products")
    public void createProductList(@Valid @RequestBody List<Product> productList){
        productService.createProductList(productList);
    }

    @GetMapping("/product/{name}")
    public Product fetchProductByName(@PathVariable("name") String productName){
        return productService.fetchProductByName(productName);
    }

    @GetMapping("/product/{id}")
    public Product fetchProductById(@PathVariable("id") Long productId) throws Exception {
        return productService.fetchProductById(productId);
    }

    @GetMapping("/products")
    public List<Product> fetchProductList(){
        return productService.fetchProductList();
    }

    @PutMapping("/product/{name}")
    public Product updateStoreDetail(@Valid @PathVariable("name") String productName,
                                     @RequestBody Product product){
        return  productService.updateProduct(productName,product);

    }

    @DeleteMapping("/product/{id}")
    public String deleteProductById(@PathVariable ("id") Long productId ){
        productService.deleteProductById(productId);
        return "Deleted Successfully";
    }

}
