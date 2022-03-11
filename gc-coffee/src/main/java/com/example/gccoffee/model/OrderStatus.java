package com.example.gccoffee.model;

// 주문 상태
public enum OrderStatus {
    // 주문 상태를 보고 출하 여부 판단
    ACCEPTED,
    PAYMENT_CONFIRMED, // 원래 REJECT 등도 있어야 함.
    READY_FOR_DELIVERY,
    SHIPPED,
    SETTED,
    CANCELLED
}
