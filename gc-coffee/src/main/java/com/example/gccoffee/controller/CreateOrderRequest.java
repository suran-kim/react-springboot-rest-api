package com.example.gccoffee.controller;

import com.example.gccoffee.model.OrderItem;

import java.util.List;

// order 요청을 처리하는 DTO 클래스
public record CreateOrderRequest(String email, String address, String postcode, List<OrderItem> orderItems) {
    // JSON을 표현하기 위한 데이터 타입 정의 가능, 어노테이션 사용 가능
    // JSON이 아닌 다른 메세지 포맷으로 변환하기 위해 필요한 기능 추가 가능
}
