package com.blog.app.Blog_App_20.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ApiResponse {
    public String message;
    private String status;
    private String statusCode;

    public ApiResponse(String message, String status, String statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }
}
