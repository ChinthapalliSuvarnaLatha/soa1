package com.example.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.model.Order;

@RestController
public class OrderController {

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {

        return "Order Placed Successfully\n"
                + "User ID : " + order.getUserId()
                + "\nRestaurant ID : " + order.getRestaurantId()
                + "\nItems : " + order.getItems();
    }

}