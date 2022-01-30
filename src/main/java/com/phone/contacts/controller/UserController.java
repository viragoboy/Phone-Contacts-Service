package com.phone.contacts.controller;

import com.phone.contacts.model.User;
import com.phone.contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")    // url -> http://localhost:9092/api
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")   // url -> http://localhost:9092/api/user
    public List<User> getAllUsers() {
        System.out.println("calling getAllUsers");
        return userService.getAllUsers();
    }
}
