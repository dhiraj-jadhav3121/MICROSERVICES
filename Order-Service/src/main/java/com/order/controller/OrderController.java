package com.order.controller;


import com.order.entity.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/allOrder")
    public List<Order> getAllOderData() {
        return orderService.getAllOrder();
    }

    @GetMapping("/getById/{id}")
    public Order getById(@PathVariable int id) {
        return orderService.getById(id);

    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        orderService.deleteById(id);

    }

    @PatchMapping("/update/{id}")
    public Order updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

}
