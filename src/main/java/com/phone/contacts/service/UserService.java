package com.phone.contacts.service;

import com.phone.contacts.model.User;
import com.phone.contacts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> user = this.userRepository.findAll();
        return user;
    }

    public User createUser(User userObject) {
        return userRepository.save(userObject);
    }
}
