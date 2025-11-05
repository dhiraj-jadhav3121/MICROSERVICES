package com.order.client;


import com.order.entity.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTAURANT-SERVICE", url = "http://localhost:8082")
public interface RestaurantClient {

    @GetMapping("/restaurant/getById/{id}")
    Restaurant getById(@PathVariable int id);
}
