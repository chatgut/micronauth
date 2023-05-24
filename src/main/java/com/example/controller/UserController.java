package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/auth")
public class UserController {

    UserRepository userRepository;

    UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Post("/register")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public User registerNew(@Body User user) {
        return userService.registerUser(user);
    }
}
