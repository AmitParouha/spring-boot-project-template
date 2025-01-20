package com.blog.app.Blog_App_20.service;

import com.blog.app.Blog_App_20.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto user);
    public UserDto updateUser(UserDto user, Integer userId);
    public UserDto getUserById(Integer userId);
    public UserDto getUserByEmail(String email);
    public List<UserDto> getAllUsers();
    public Boolean deleteUser(Integer userId);

}
