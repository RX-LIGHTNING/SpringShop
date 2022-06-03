package com.stationary.shop.repo;

import com.stationary.shop.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order,Long> {
}
