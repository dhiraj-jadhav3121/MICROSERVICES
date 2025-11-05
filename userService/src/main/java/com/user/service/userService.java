package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface userService {


    User saveUser(User user);


    List<User> getAllUser();

    User findByOrderId(int id);

    void deleteById(int id);

    User updateUser(Integer id, User user);
}
