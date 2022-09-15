package com.example.gccoffee.service;

import com.example.gccoffee.model.Email;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderItem;

import java.util.List;

// 주문을 받는 비즈니스 로직 수행
public interface OrderService {
    Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems);
}

