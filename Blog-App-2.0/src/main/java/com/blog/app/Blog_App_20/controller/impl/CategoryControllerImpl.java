package com.blog.app.Blog_App_20.controller.impl;

import com.blog.app.Blog_App_20.dto.ApiResponse;
import com.blog.app.Blog_App_20.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.app.Blog_App_20.dto.ApiResponse;
import com.blog.app.Blog_App_20.dto.CategoryDto;
import com.blog.app.Blog_App_20.service.CategoryService;
import java.util.List;
import com.blog.app.Blog_App_20.controller.CategoryController;


@RestController
public class CategoryControllerImpl implements CategoryController {

    private CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), null, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto, Integer categoryId) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto, categoryId), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Integer categoryId) {
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteCategory(Integer categoryId) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(categoryService.deleteCategory(categoryId), "success", HttpStatus.OK.value()+""), HttpStatus.OK);
    }
}

