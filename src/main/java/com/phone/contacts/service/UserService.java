package com.phone.contacts.service;

import com.phone.contacts.model.User;
import com.phone.contacts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUser(Long userId) {
        Optional<User> user = this.userRepository.findById(userId);
        return user;
    }

    public User updateUser(Long userId, User userObject) {
        Optional<User> optionalObject = this.userRepository.findById(userId);
        if (optionalObject.isPresent()) {
            User user = optionalObject.get();
            user.setName(userObject.getName());
            return userRepository.save(user);
        } else {
            System.out.println("User doesn't exist.");
        }
        return null;
    }
}
