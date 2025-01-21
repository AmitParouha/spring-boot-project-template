package com.blog.app.Blog_App_20.repository;

import com.blog.app.Blog_App_20.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
