package com.stationary.shop.repo;

import com.stationary.shop.entities.Order;
import com.stationary.shop.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface OrderRepo extends CrudRepository<Order,Long> {

    List<Order> getOrdersByUser(User user);

}
