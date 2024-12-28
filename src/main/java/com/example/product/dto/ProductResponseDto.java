package com.example.product.dto;

import com.example.product.models.Product;
import lombok.Getter;

public class ProductResponseDto {

    private ProductDto product;
    private String status;
    private String message;
    public ProductResponseDto(ProductDto product, String status, String message) {
        this.product = product;
        this.status = status;
        this.message = message;
    }
    public ProductResponseDto() {}

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
