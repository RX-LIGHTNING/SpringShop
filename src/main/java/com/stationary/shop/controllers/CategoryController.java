package com.stationary.shop.controllers;

import com.stationary.shop.entities.Category;
import com.stationary.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/AdminPanel/category/add")
    public String getCategoryAddPage(Model model){
        model.addAttribute("Category", new Category());
        return "AdminPanel/CategoryCRUD/CategoryAdd";
    }
    @GetMapping("/AdminPanel/Categories")
    public String getCategoriesListPage(Model model){
        model.addAttribute("Categories", categoryService.getCategoryRepo().findAll());
        return "AdminPanel/CategoryCRUD/CategoryList";
    }
    @PostMapping("/AdminPanel/category/add/accept")
    public String categoryAddAccept(Model model, @ModelAttribute("Category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/Store";
    }
    @GetMapping("/AdminPanel/category/edit")
    public String getCategoryEditPage(Model model, @RequestParam(name="id", required = true)long id){
        model.addAttribute("Category", categoryService.getCategoryRepo().findById(id));
        return "AdminPanel/CategoryCRUD/CategoryEdit";
    }
    @PostMapping("/AdminPanel/category/edit/accept")
    public String categoryEditAccept(Model model, @ModelAttribute("Category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/Store";
    }
}
