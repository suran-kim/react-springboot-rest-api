package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// CRUD를 정의하는 인터페이스
public interface ProductRepository {
    List<Product> findAll(); // 모두 검색

    Product insert(Product product); // 상품 추가
    Product update(Product product); // 상품 정보 업데이트

    Optional<Product> findById(UUID productId); // 상품 id로 검색
    Optional<Product> findByName(String productName); // 상품 이름으로 검색

    List<Product> findByCategory(Category category); // 카테고리로 검색

    void deleteAll(); // 모두 삭제
}
