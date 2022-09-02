package com.example.gccoffee.controller;

import com.example.gccoffee.model.Category;

// product 요청을 처리하는 DTO 클래스
public record CreateProductRequest(String productName, Category category, long price, String description ) {

}
