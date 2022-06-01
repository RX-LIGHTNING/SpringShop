package com.stationary.shop.controllers;

import com.stationary.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
    @Autowired
    ProductService productService;
    @GetMapping("/Store")
    public String getShopPage(Model model){
        model.addAttribute("products", productService.getProducts());
        return "Store";
    }
}
