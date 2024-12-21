package com.example.product.controller;

import com.example.product.models.Product;
import com.example.product.service.ProductInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")

public class ProductController {
   //this is help to create product

    private final ProductInterface productService;

    public ProductController(ProductInterface productService) {
        this.productService = productService;
    }

    @PostMapping
    public List<Product> createProduct() {
        return List.of();
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //this will help to get product by id
    @GetMapping( "/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Product product) {}

    @DeleteMapping( "/{id}")
    public void deleteProduct(@PathVariable String id) {

    }

}
