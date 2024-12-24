package com.example.product.service;

import com.example.product.models.Product;
import com.example.product.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements  ProductInterface {

    private RestTemplate restTemplate;
    private String fakeStoreURL;

    public ProductService(RestTemplate restTemplate, String fakeStoreURL) {
        this.restTemplate = restTemplate;
        this.fakeStoreURL = fakeStoreURL;
    }
    @Override
    public List<Product> getAllProducts() {
        System.out.println("getAllProducts" + fakeStoreURL);
        ProductDto [] productDtos= restTemplate.getForObject(fakeStoreURL, ProductDto[].class);
        System.out.println(productDtos);
        List<Product> response = new ArrayList<>();
        for(ProductDto productDto : productDtos){
            response.add(productDto.getProduct());
        }

        return response;
    }

    @Override
    public Product createProduct(Long id, String name, String description, Double price, String category) {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setTitle(name);
        productDto.setDescription(description);
        productDto.setPrice(price);
        productDto.setCategory(category);
        ProductDto p = restTemplate.postForObject(fakeStoreURL, productDto, ProductDto.class);
        return p.getProduct();
    }

    ;
    @Override
    public  Product getProductById(Long id) {
        System.out.println(fakeStoreURL+"/"+id);
        ProductDto d = restTemplate.getForObject(fakeStoreURL+"/"+id, ProductDto.class);
        return d.getProduct();
    };

    @Override
    public Product updateProduct(Long id, String title, String description, Double price, String category) {

        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setTitle(title);
        productDto.setDescription(description);
        productDto.setPrice(price);
        productDto.setCategory(category);
        ProductDto p = restTemplate.postForObject(fakeStoreURL+"/"+id, productDto, ProductDto.class);
        return p.getProduct();
    }

    @Override
    public String deleteProduct(Long id) {
        restTemplate.delete(fakeStoreURL+"/"+id);
        return "Product deleted";
    }
}
