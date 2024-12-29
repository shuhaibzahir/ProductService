package com.example.product.execptions;

public class ProductNotFoundException extends Exception {
    //create a object for product not found exception class and pass the message to super
    public ProductNotFoundException(String message) {
        super(message);
    }
}
