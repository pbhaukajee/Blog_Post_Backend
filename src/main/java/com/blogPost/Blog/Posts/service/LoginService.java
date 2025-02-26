package com.blogPost.Blog.Posts.service;

import com.blogPost.Blog.Posts.entity.Login;
import com.blogPost.Blog.Posts.repository.LoginRepository;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public Login saveUser(Login user){
     return loginRepository.save(user);
    }
}
