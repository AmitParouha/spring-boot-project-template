package com.blog.app.Blog_App_20.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
    private Integer id;

    @NotBlank(message = "Category_Name cannot be blank")
    private String name;

    @NotBlank(message = "Category_Description cannot be blank")
    private String description;

    public CategoryDto(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CategoryDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
