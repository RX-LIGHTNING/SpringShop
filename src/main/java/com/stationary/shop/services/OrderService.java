package com.stationary.shop.services;

import com.stationary.shop.entities.Order;
import com.stationary.shop.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    public void saveOrder(Order order){
        orderRepo.save(order);
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }
}
