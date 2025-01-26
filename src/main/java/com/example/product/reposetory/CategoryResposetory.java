package com.example.product.reposetory;

import com.example.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryResposetory extends JpaRepository<Category, Long> {
    Category findByTitle(String title);
    Category findById(long id);
    Category save(Category category);
}
