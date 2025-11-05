package com.user.controller;

import com.user.entity.User;
import com.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);

    }

    @GetMapping("/allUser")
    public List<User> getAllUser() {

        return userService.getAllUser();
    }

    @GetMapping("/getById/{id}")
    public User findByOrderId(@PathVariable int id) {
        return userService.findByOrderId(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteById(@PathVariable int id) {
        userService.deleteById(id);

    }

    @PatchMapping("/update/{id}")
    private User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);


    }

}
