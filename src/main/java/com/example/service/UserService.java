package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

@Singleton
public class UserService {

    UserRepository userRepository;

    PasswordEncoderService passwordEncoderService;

    public UserService(UserRepository userRepository, PasswordEncoderService passwordEncoderService) {
        this.userRepository = userRepository;
        this.passwordEncoderService = passwordEncoderService;
    }

    @Transactional
    public User registerUser(User user) {
        try {
            String encodedPassword = passwordEncoderService.encode(user.getPassword());
            User newUser = new User(user);
            newUser.setUsername(user.getUsername());
            newUser.setPassword(encodedPassword);
            newUser = userRepository.save(newUser);

            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            return false;
        return passwordEncoderService.matches(password, user.getPassword());
    }
}
