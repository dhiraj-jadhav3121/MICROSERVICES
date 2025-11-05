package com.user.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.user.client.OrderClient;
import com.user.entity.Order;
import com.user.entity.User;
import com.user.repository.userRepository;
import com.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository repository;

    @Autowired
    private OrderClient orderClient;


    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User findByOrderId(int id) {

        User user = repository.findById(id).get();

        Order order = orderClient.getById(id);

        user.setOrder(order);

        return user;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public User updateUser(Integer id, User user) {

        User use;

        Optional<User> exctingUser = repository.findById(id);

        if (exctingUser.isEmpty()) {
            throw new RuntimeException("Id not Found...");

        } else {
            use = exctingUser.get();

            if (StringUtil.notNullNorEmpty(user.getName())) {
                use.setName(user.getName());
            }

            if (StringUtil.notNullNorEmpty(user.getEmail())) {
                use.setEmail(user.getEmail());
            }
            if (StringUtil.notNullNorEmpty(user.getPhoneNumber())) {
                use.setPhoneNumber(user.getPhoneNumber());
            }
        }

        return repository.save(use);

    }
}
