package com.example.product.models;


import jakarta.persistence.Entity;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class Category extends BaseModel {
    private String title;
    private String description;
}
