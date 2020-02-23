package com.example.springbootthymeleaf.service;

import com.example.springbootthymeleaf.pojo.User;

import java.util.List;

public interface UserLoginService {
         User userLogin(User user);

         User findByUsername(String username);

    Integer getRegister(User user);
}
