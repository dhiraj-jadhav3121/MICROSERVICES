package com.order.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int orderId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String price;
    private String mobileNo;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Transient
    private Restaurant restaurant;


}
