package com.stationary.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/AdminPanel")
    public String getAdminPage(Model model){
        return "/AdminPanel/Panel";
    }
}
