package com.example.CRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD.model.MyUser;
import com.example.CRUD.model.MyUserRepository;


@RestController
public class RegistrationController {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public MyUser createUser(@RequestBody MyUser user) {
        System.err.println("registerd");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.err.println(user.getPassword());
        System.err.println(user.getUsername());
        return myUserRepository.save(user);
    }
}
