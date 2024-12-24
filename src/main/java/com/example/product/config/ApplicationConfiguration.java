package com.example.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationConfiguration {

    private String fakeStoreURL = "https://fakestoreapi.in/api/products";

    @Bean
    public String getFakeStoreURL(){
        return fakeStoreURL;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
