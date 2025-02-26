package com.blogPost.Blog.Posts.controller;


import com.blogPost.Blog.Posts.entity.Login;
import com.blogPost.Blog.Posts.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Login> saveUser(@RequestBody Login user){
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.saveUser(user));
    }
}
