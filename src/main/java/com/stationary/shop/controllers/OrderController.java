package com.stationary.shop.controllers;

import com.stationary.shop.entities.Order;
import com.stationary.shop.entities.Product;
import com.stationary.shop.entities.enums.OrderStatus;
import com.stationary.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/Orders")
    public String getCategoryAddPage(Model model){
        model.addAttribute("orders",orderService.getOrdersByCurrentUser());
        return "Orders";
    }
    @GetMapping("/order/add")
    public String getOrderAddPage(Model model) {
        model.addAttribute("Order", new Order());
        model.addAttribute("orderStatuses", OrderStatus.values());
        return "OrderCRUD/OrderAdd";
    }
    @GetMapping("/order/edit")
    public String getOrderEditPage(Model model, @RequestParam(name="id", required = true)long id) {
        model.addAttribute("Order", orderService.getOrderRepo().findById(id));
        model.addAttribute("orderStatuses", OrderStatus.values());
        return "OrderCRUD/OrderEdit";
    }
    @PostMapping("/order/add/accept")
    public String orderAddAccept(Model model, @ModelAttribute("Order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/Store";
    }
    @PostMapping("/order/edit/accept")
    public String orderEditAccept(Model model, @ModelAttribute("Order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/Store";
    }
    @PostMapping("/order/cancel")
    public String orderCancel(Model model, @ModelAttribute("id") Long id) {
        orderService.cancelOrder(id);
        return "redirect:/Orders";
    }
}
