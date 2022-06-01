package com.stationary.shop.controllers;

import com.stationary.shop.entities.Product;
import com.stationary.shop.entities.User;
import com.stationary.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/product/add")
    public String getProductAddPage(Model model){
        model.addAttribute("Product", new Product());
        return "ProductAdd";
    }
    @GetMapping("/product/edit")
    public String getProductEditPage(Model model, @RequestParam(name="id", required = true)long id){
        model.addAttribute("Product", productService.getProdRepo().findById(id).get());
        return "ProductEdit";
    }
    @PostMapping("/product/add/accept")
    public String productAddAccept(Model model, @ModelAttribute("Product") Product product){
        productService.saveProduct(product);
        return "redirect:/Store";
    }
    @PostMapping("/product/edit/accept")
    public String productEditAccept(Model model, @ModelAttribute("Product") Product product){
        productService.updateProduct(product);
        return "redirect:/Store";
    }
}