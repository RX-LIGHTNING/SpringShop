package com.stationary.shop.services;

import com.stationary.shop.entities.Order;
import com.stationary.shop.entities.enums.OrderStatus;
import com.stationary.shop.repo.OrderRepo;
import com.stationary.shop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    UserRepo userRepo;

    public void saveOrder(Order order) {
        if (order.getId() == null) {
            order.setUser(userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
            order.setOrderStatus(OrderStatus.OPENED);
        }
        orderRepo.save(order);
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }
}
