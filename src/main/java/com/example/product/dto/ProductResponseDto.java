package com.example.product.dto;

import com.example.product.models.Product;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private ProductDto product;
    private String status;
    private String message;

}
