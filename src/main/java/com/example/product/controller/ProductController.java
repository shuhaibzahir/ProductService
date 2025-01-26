package com.example.product.controller;

import com.example.product.dto.ErrorDto;
import com.example.product.execptions.ProductNotFoundException;
import com.example.product.models.Product;
import com.example.product.service.ProductInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping(path = "/products")

public class ProductController {
   //this is help to create product

    private final ProductInterface productService;

    public ProductController(@Qualifier("selfProductService") ProductInterface productService) {
        this.productService = productService;
    }

    @PostMapping
    public  Product  createProduct(@RequestBody Product product) {
        return productService.createProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getTitle()
        );

    }

    //this will help to get product by id
    @GetMapping( "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
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
                product.getCategory().getTitle()
        );

    }

    @DeleteMapping( "/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @ExceptionHandler({ProductNotFoundException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorDto> errorException(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        System.out.println(errorDto.getMessage());
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }



}
