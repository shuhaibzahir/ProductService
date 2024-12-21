package com.example.product.service;

import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements  ProductInterface {

    @Override
    public List<Product> getAllProducts() {
        System.out.println("getAllProducts");
        return null;
    };
    @Override
    public  Product getProductById(Long id) {
        System.out.println("getProductById");
        return null;
    };
    @Override
    public Product createProduct(Product product) {
        System.out.println("createProduct");
        return null;
    }


}
