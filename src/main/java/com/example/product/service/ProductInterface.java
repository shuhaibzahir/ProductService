package com.example.product.service;

import com.example.product.models.Product;

import java.util.List;

public interface ProductInterface {

    Product getProductById(Long Id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
