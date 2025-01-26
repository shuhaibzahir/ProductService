package com.example.product.service;

import com.example.product.dto.ProductResponseDto;
import com.example.product.execptions.ProductNotFoundException;
import com.example.product.models.Product;
import com.example.product.dto.ProductDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductInterface {

    private RestTemplate restTemplate;
    private String fakeStoreURL;

    public FakeStoreProductService(RestTemplate restTemplate, String fakeStoreURL) {
        this.restTemplate = restTemplate;
        this.fakeStoreURL = fakeStoreURL;
    }
    @Override
    public List<Product> getAllProducts() {
        ProductDto[] productDtos= restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            products.add(productDto.getProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(Long id, String name, String description, String price, String category) {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setTitle(name);
        productDto.setDescription(description);
        productDto.setPrice(price);
        productDto.setImage(fakeStoreURL);
        productDto.setCategory(category);
        System.out.println(productDto);
        ProductResponseDto p = restTemplate.postForObject(fakeStoreURL, productDto, ProductResponseDto.class);
        return p.getProduct().getProduct();
    }

    ;
    @Override
    public  Product getProductById(Long id) throws ProductNotFoundException {
        System.out.println(fakeStoreURL+"/"+id);
        ProductResponseDto d = restTemplate.getForObject(fakeStoreURL+"/"+id, ProductResponseDto.class);
        ProductDto productDto = d.getProduct();
        if(productDto == null){
            throw new ProductNotFoundException("Product not found");
        }

        return productDto.getProduct();
    };

    @Override
    public Product updateProduct(Long id, String title, String description, String price, String category) {

        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setTitle(title);
        productDto.setDescription(description);
        productDto.setPrice(price);
        productDto.setCategory(category);
        productDto.setImage(fakeStoreURL);

        System.out.println(productDto);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<ProductDto> requestEntity = new HttpEntity<>(productDto, headers);

        ResponseEntity<ProductResponseDto> p = restTemplate.exchange(fakeStoreURL+"/"+id, HttpMethod.PUT, requestEntity, ProductResponseDto.class);

        System.out.println(p);
        return p.getBody().getProduct().getProduct();
    }

    @Override
    public String deleteProduct(Long id) {
        restTemplate.delete(fakeStoreURL+"/"+id);
        return "Product deleted";
    }
}
