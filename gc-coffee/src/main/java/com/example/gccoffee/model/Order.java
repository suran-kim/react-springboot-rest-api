package com.example.gccoffee.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// 주문
public class Order {
    private final UUID orderId;
    private final Email email; // 이메일에 대한 Value Object 만들기
    private String address; // 미리 입력한 주소지를 UUID로 받아오게 할 수도 있다.
    private String postcode;
    private final List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자 -----------
    public Order(UUID orderId, Email email, String address, String postcode, List<OrderItem> orderItems, OrderStatus orderStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter ------------
    public UUID getOrderId() {
        return orderId;
    }

    public Email getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setter -------------------------
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = LocalDateTime.now();
    }
}

