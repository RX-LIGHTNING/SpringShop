package com.stationary.shop.repo;

import com.stationary.shop.entities.Category;
import com.stationary.shop.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {
}
