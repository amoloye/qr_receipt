package com.example.qr_receipt.service.impl;

import com.example.qr_receipt.entity.Product;
import com.example.qr_receipt.repository.ProductRepository;
import com.example.qr_receipt.service.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private static final String  ProductNotFoundException = "Department Not Available";

    private final ProductRepository productRepository;



    @Override
    public void createProduct (Product product) {
        product.setProductPrice(product.getUnitPrice() * product.getQuantity());
         productRepository.save(product);
    }

    @Override
    public void createProductList (List<Product> productList) {

        productRepository.saveAll(productList);

    }

    @Override
    public Product updateProduct (Long productId, Product product) {
        Product productDB = productRepository.findById(productId).get();

        if (Objects.nonNull(product.getProductName())&&
                !"".equalsIgnoreCase(product.getProductName())){
            productDB.setProductName(product.getProductName());
        }
        if (product.getQuantity()!=0){
            productDB.setQuantity(product.getQuantity());
        }

        if (product.getProductPrice()!=0){
            productDB.setQuantity(product.getQuantity());
        }

        return productRepository.save(productDB);
    }

    @Override
    public void deleteProductById (Long productId) {
        productRepository.deleteByProductId(productId);

    }

    @Override
    public Product fetchProductByName (String productName) {
        return productRepository.findByProductNameIgnoreCase(productName);
    }

    @Override
    public Product fetchProductById (Long productId) throws Exception {

        Optional<Product>product=  productRepository.findById(productId);
        if (product.isEmpty()){
            throw new Exception(ProductNotFoundException);
        }
        return product.get();

    }


    @Override
    public List<Product> fetchProductList () {
        return productRepository.findAll();
    }











}
