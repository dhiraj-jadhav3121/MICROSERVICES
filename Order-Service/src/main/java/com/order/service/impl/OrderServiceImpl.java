package com.order.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.order.client.RestaurantClient;
import com.order.entity.Order;
import com.order.entity.Restaurant;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantClient restaurantClient;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getById(int id) {
        Order order = orderRepository.findById(id).get();
        Restaurant restaurant = restaurantClient.getById(id);
        order.setRestaurant(restaurant);
        System.out.println("OrederRecived:" + order);
        return order;
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order updateOrder(Integer id, Order order) {

        Order oder;
        Optional<Order> existingOrder = orderRepository.findById(id);

        if (existingOrder.isEmpty()) {

            throw new RuntimeException("Id Not Found");
        } else {

            oder = existingOrder.get();

            if (StringUtil.notNullNorEmpty(order.getName())) {

                oder.setName(order.getName());
            }

            if (order.getCategory() != null || !ObjectUtils.isEmpty(order.getCategory())) {

                oder.setCategory(order.getCategory());
            }


            if (StringUtil.notNullNorEmpty(order.getPrice())) {
                oder.setPrice(order.getPrice());
            }

            if (StringUtil.notNullNorEmpty(order.getMobileNo())) {
                oder.setMobileNo(order.getMobileNo());
            }

            if (order.getStatus() != null || !ObjectUtils.isEmpty(order.getStatus())) {

                oder.setStatus(order.getStatus());
            }


        }

        return orderRepository.save(oder);


    }

}
