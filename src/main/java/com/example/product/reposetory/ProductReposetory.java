package com.example.product.reposetory;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposetory extends JpaRepository<Product, Long> {
    //save

    //get

    //get all

    //update
    Product save(Product product);

    //delete
    Product findByName(String name);
    Product findByDescription(String description);
}
