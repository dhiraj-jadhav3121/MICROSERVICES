package com.user.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String name;
    private String category;
    private String price;
    private String mobileNo;
    private String status;

    private Restaurant restaurant;
}
