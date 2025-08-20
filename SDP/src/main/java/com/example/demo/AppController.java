package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin // Allows cross-origin requests
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/use")
    public Map<String, Object> registerUser(@RequestBody Userss user) {
        Map<String, Object> response = new HashMap<>();

        
        if (userRepository.findByUsername(user.getUsername()) != null) {
            response.put("success", false);
            response.put("message", "Username already exists");
            return response;
        }

        // Save the user to the database with plain text password
        userRepository.save(user);

        response.put("success", true);
        response.put("message", "User registered successfully");
        response.put("username", user.getUsername());

        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

       
        Userss user = userRepository.findByUsername(username);

        Map<String, Object> response = new HashMap<>();

        // Check if user exists and password matches (plain text)
        if (user != null && user.getPassword().equals(password)) {
            response.put("success", true);
            response.put("message", "Login successful");
            response.put("username", user.getUsername());
            response.put("fullName", user.getFullName());
            response.put("email", user.getEmail());
        } else {
            response.put("success", false);
            response.put("message", "Invalid username or password");
        }

        return response;
    }

    
    }

