package com.example.product.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String price;
    @ManyToOne
    private Category category;
    private String imageUrl;
}
