package com.example.product.dto;

//{
//        "id": 1,
//        "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//        "price": 109.95,
//        "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//        "category": "men's clothing",
//        "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//        "rating": {
//        "rate": 3.9,
//        "count": 120
//        }
//        }

import com.example.product.models.Category;
import com.example.product.models.Product;
import lombok.Getter;
import lombok.Setter;


public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product getProduct(){
        Product product = new Product();
        Category c = new Category();
        c.setName(category);
        product.setId(id);
        product.setTitle(title);
        product.setCategory(c);
        product.setDescription(description);
        product.setPrice(price);
        return product;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + this.id +
                ", title='" + this.title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
