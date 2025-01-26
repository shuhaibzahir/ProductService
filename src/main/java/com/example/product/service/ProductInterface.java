package com.example.product.service;

import com.example.product.execptions.ProductNotFoundException;
import com.example.product.models.Product;

import java.util.List;

public interface ProductInterface {

    Product getProductById(Long Id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Long id, String title, String description, String price, String category);
    Product updateProduct(Long id, String title, String description, String price, String category);
    String deleteProduct(Long id);
}
