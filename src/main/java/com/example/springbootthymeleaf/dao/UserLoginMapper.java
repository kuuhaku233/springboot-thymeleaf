package com.example.springbootthymeleaf.dao;

import com.example.springbootthymeleaf.pojo.User;

import java.util.List;

public interface UserLoginMapper {

    User findByUsername(String username);

    User userLogin(User user);

    List<User> findAll();

    Integer getRegister(User user);
}