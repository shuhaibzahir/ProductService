package com.example.product.reposetory;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductReposetory extends JpaRepository<Product, Long> {
    //save

    //get

    //get all

    //update
    Product save(Product product);
    Product findByTitle(String title);

}
