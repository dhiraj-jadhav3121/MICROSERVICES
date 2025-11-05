package com.restaurant.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int restaurantId;
    private String restaurantName;
    private String location;
    private double rating;
}
