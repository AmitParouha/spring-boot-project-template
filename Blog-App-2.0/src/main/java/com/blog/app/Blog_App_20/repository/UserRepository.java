package com.blog.app.Blog_App_20.repository;

import com.blog.app.Blog_App_20.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

}
