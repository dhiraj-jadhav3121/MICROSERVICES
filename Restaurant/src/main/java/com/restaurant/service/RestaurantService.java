package com.restaurant.service;

import com.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantService {


    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurant();

    Restaurant getById(int id);

    void deleteById(int id);

    Restaurant updateRestaurant(int id , Restaurant restaurant);
}
