package com.blog.app.Blog_App_20.controller.impl;

import com.blog.app.Blog_App_20.controller.UserController;
import com.blog.app.Blog_App_20.dto.ApiResponse;
import com.blog.app.Blog_App_20.dto.UserDto;
import com.blog.app.Blog_App_20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);
        return new ResponseEntity<UserDto>(userDto1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto user, Integer userId) {
        UserDto userDto = userService.updateUser(user, userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Integer userId) {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        UserDto userDto = userService.getUserByEmail(email);
        if(userDto == null) {
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteUser(Integer userId) {
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", "success", HttpStatus.OK.value()+""), HttpStatus.OK);
    }
}
