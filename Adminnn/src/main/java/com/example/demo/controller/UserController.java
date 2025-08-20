// src/main/java/com/example/demo/controller/UserController.java
package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React app to access this endpoint
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String fun1()
    {
      return "Welcome1";
    }
    @PostMapping("/addrole")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user); // Save and return the user
    }
    @GetMapping("/giverole")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
