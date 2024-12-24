package com.example.product.controller;

import com.example.product.models.Product;
import com.example.product.service.ProductInterface;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public  Product  createProduct(@RequestBody Product product) {
        return productService.createProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getName()
        );

    }

    //this will help to get product by id
    @GetMapping( "/{id}")
    public Product getProductById(@PathVariable Long id){
            return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }



    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(
                id,
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getName()
        );

    }

    @DeleteMapping( "/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
