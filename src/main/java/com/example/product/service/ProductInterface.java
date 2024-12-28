package com.example.product.service;

import com.example.product.models.Product;

import java.util.List;

public interface ProductInterface {

    Product getProductById(Long Id);
    List<Product> getAllProducts();
    Product createProduct(Long id, String name, String description, String price, String category);
    Product updateProduct(Long id, String name, String description, String price, String category);
    String deleteProduct(Long id);
}
