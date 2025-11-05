package com.restaurant.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.restaurant.entity.Restaurant;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {

        return repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return repository.findAll();
    }

    @Override
    public Restaurant getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Restaurant updateRestaurant(int id, Restaurant restaurant) {
        Restaurant rest;
        Optional<Restaurant> exiting = repository.findById(id);

        if (exiting.isEmpty()) {
            throw new RuntimeException("Restaurant Not Found ...");

        } else {
            rest = exiting.get();
            if (StringUtil.notNullNorEmpty(restaurant.getRestaurantName())) {
                rest.setRestaurantName(restaurant.getRestaurantName());
            }

            if (StringUtil.notNullNorEmpty(restaurant.getLocation())) {
                rest.setLocation(restaurant.getLocation());
            }

            if (ObjectUtils.isEmpty(restaurant.getRating())) {

                rest.setRating(restaurant.getRating());
            }

        }
        return repository.save(restaurant);
    }

}
