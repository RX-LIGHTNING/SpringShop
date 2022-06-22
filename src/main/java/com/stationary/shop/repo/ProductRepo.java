package com.stationary.shop.repo;

import com.stationary.shop.entities.Product;
import com.stationary.shop.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.description, p.producer) LIKE %?1%")
    List<Product> search(String keyword);
}
