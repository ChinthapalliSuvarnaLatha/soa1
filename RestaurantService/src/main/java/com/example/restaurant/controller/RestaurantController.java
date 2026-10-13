package com.example.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.model.Restaurant;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {

        List<Restaurant> list = new ArrayList<>();

        list.add(new Restaurant(101,"Dominos","Hyderabad"));
        list.add(new Restaurant(102,"KFC","Vijayawada"));
        list.add(new Restaurant(103,"Pizza Hut","Guntur"));

        return list;
    }

}
