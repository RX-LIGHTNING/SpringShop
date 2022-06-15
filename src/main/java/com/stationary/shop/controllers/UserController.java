package com.stationary.shop.controllers;

import com.stationary.shop.entities.User;
import com.stationary.shop.entities.enums.Role;
import com.stationary.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/AdminPanel/Users")
    public String getListPage(Model model){
        model.addAttribute("Users",userService.getUserRepo().findAll());
        return "/AdminPanel/UserCRUD/UserList";
    }
    @GetMapping("/AdminPanel/Users/edit")
    public String getEditPage(Model model, @RequestParam(name="id", required = true)long id){
        model.addAttribute("User",userService.getUserRepo().findById(id).get());
        model.addAttribute("Roles", Role.values());
        return "/AdminPanel/UserCRUD/UserEdit";
    }
    @PostMapping("/AdminPanel/Users/edit/accept")
    public String EditAcceptPage(Model model, User user, @RequestParam(value = "selected", required = false)Role[] selected){
        userService.edit(user, selected);
        return "redirect:/AdminPanel/Users";
    }
    @PostMapping("/register/accept")
    public String userRegister(@ModelAttribute("User") User user){
        userService.registration(user);
        return "redirect:/";
    }
}
