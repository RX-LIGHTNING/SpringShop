package com.stationary.shop.repo;

import com.stationary.shop.entities.Product;
import com.stationary.shop.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {

}
