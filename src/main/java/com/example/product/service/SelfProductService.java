package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.execptions.ProductNotFoundException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.reposetory.CategoryResposetory;
import com.example.product.reposetory.ProductReposetory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService  implements  ProductInterface{
    private ProductReposetory productReposetory;
    private CategoryResposetory categoryResposetory;
    public SelfProductService(ProductReposetory productReposetory, CategoryResposetory categoryResposetory) {
        this.productReposetory = productReposetory;
        this.categoryResposetory = categoryResposetory;
    }
    @Override
    public Product getProductById(Long Id) throws ProductNotFoundException {
        Optional<Product> product = productReposetory.findById(Id);

        if(product.isPresent()) {
            return product.get();
        }
         throw new ProductNotFoundException("Product not found");
    }

    @Override
    public List<Product> getAllProducts() {
        return productReposetory.findAll();
    }

    @Override
    public Product createProduct(Long id, String title, String description, String price, String category) {

        Category cat = categoryResposetory.findByTitle(category);
        if(cat == null) {
            cat = new Category();
            cat.setTitle(category);
            cat = categoryResposetory.save(cat);
        }
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(cat);
        return productReposetory.save(product);
    }

    @Override
    public Product updateProduct(Long id, String name, String description, String price, String category) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return "";
    }
}
