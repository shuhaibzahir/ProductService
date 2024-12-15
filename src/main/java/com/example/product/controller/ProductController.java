package com.example.product.controller;

import com.example.product.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
   //this is help to create product

//    @RequestMapping(value="/product", method = RequestMethod.POST)
    @PostMapping("/products")
    public void createProduct(Product product) {

    }

    //this will help to get product by id
    public Product getProductById(Long id){
        return null;
    }

    public void updateProduct(Product product, Long id) {}

    public void deleteProduct(Long id) {}

}
