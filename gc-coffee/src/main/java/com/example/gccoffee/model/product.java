package com.example.gccoffee.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

// 상품 - 커피 bean 패키지
public class Product {
    private final UUID productId; // 한 번 만들어지면 변경 불가 -> final
    private String productName;
    private Category category;// 카테고리 설정 방식 두 가지 : 동적/정적
    private long price; // 원화만 지원한다면 long타입
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자  --------
    public Product(UUID productId, String productName, Category category, long price) { // 필수 생성자
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;

        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    public Product(UUID productId, String productName, Category category, long price, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter  --------
    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setter (불변이 아닌 필드만 생성)  --------
    public void setPrice(long price) {
        this.price = price;
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS); // 값 변경 때마다 업데이트 날짜 변경
    }

    public void setCategory(Category category) {
        this.category = category;
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS); // 값 변경 때마다 업데이트 날짜 변경
    }

    public void setProductName(String productName) {
        this.productName = productName;
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS); // 값 변경 때마다 업데이트 날짜 변경
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS); // 값 변경 때마다 업데이트 날짜 변경
    }
}
