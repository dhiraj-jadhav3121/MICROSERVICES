package com.restaurant.controller;

import com.restaurant.entity.Restaurant;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping("/save")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return service.saveRestaurant(restaurant);

    }

    @GetMapping("/allRestaurant")
    public List<Restaurant> allRestaurant() {

        return service.getAllRestaurant();

    }

    @GetMapping("/getById/{id}")
    public Restaurant getById(@PathVariable int id) {
        return service.getById(id);

    }
@DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @PatchMapping("/update/{id}")
    public Restaurant updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
        return service.updateRestaurant(id, restaurant);
    }

}
