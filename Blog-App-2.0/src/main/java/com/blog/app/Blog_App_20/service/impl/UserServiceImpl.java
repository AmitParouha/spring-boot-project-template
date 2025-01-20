package com.blog.app.Blog_App_20.service.impl;

import com.blog.app.Blog_App_20.dto.UserDto;
import com.blog.app.Blog_App_20.entity.User;
import com.blog.app.Blog_App_20.exception.ResourceNotFoundException;
import com.blog.app.Blog_App_20.repository.UserRepository;
import com.blog.app.Blog_App_20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user1 = mapToUser(userDto);
        return mapToUserDto(userRepository.save(user1));
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        UserDto userDto1 = getUserById(userId);
        User user1 = mapToUser(userDto);
        user1.setId(userId);
        return mapToUserDto(userRepository.save(user1));
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
        return mapToUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return mapToUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user->mapToUserDto(user)).toList();
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        UserDto userDto = getUserById(userId);
        userRepository.deleteById(userId);
        return true;
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setAbout(user.getAbout());
        userDto.setImage(user.getImage());
        userDto.setToken(user.getToken());
        return userDto;
    }

    private User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setAbout(userDto.getAbout());
        user.setImage(userDto.getImage());
        user.setToken(userDto.getToken());
        return user;
    }
}
