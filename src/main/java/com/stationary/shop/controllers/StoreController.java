package com.stationary.shop.controllers;

import com.stationary.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class StoreController {
    @Autowired
    ProductService productService;
    @GetMapping("/Store")
    public String getShopPage(Model model, @Param("keyword") String keyword){
        if(keyword!=null)
        {
            model.addAttribute("products", productService.getProdRepo().search(keyword));
        }
        else{
            model.addAttribute("products", productService.getProducts());
        }
        return "Store";
    }
}
