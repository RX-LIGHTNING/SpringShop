package com.stationary.shop.services;

import com.stationary.shop.entities.Category;
import com.stationary.shop.entities.Product;
import com.stationary.shop.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public void saveCategory(Category category){
        categoryRepo.save(category);
    }

    public void deleteCategory(long id) {
        categoryRepo.deleteById(id);
    }
}
