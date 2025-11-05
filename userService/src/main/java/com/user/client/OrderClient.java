package com.user.client;

import com.user.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDER-SERVICE", url = "http://localhost:8081")
public interface OrderClient {

    @GetMapping("/order/getById/{id}")
    Order getById(@PathVariable int id);


}
