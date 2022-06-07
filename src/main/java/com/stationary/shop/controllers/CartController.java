package com.stationary.shop.controllers;

import com.stationary.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @Autowired
    OrderService orderService;

    @GetMapping("/Cart")
    public String getCategoryAddPage(Model model){
        model.addAttribute("orders",orderService.getOrdersByCurrentUser());
        return "Cart";
    }
}
