package com.stationary.shop.controllers;

import com.stationary.shop.entities.User;
import com.stationary.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "Login";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("User",new User());
        return "Register";
    }
    @PostMapping("/register/accept")
    public String userRegister(@ModelAttribute("User") User user){
        userService.registration(user);
        return "redirect:/";
    }
}
