package com.stationary.shop.repo;

import com.stationary.shop.entities.Order;
import com.stationary.shop.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order,Long> {

    List<Order> getOrdersByUser(User user);
}
