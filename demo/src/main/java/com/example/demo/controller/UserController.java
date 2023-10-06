package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Controller
public class UserController<userRepository> {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/form")
    public String showForm() {
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        
        String generatedPassword = "example123"; 

        user.setPassword(generatedPassword);
        userRepository.save(user);
        return "redirect:/form";
    }
}
