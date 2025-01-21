package com.blog.app.Blog_App_20.service;

import com.blog.app.Blog_App_20.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategories();

    String deleteCategory(Integer categoryId);


}
