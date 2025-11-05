package com.order.service;


import com.order.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrder();


    Order saveOrder(Order order);

    Order getById(int id);

    void deleteById(int id);

    Order updateOrder(Integer id, Order order);
}
