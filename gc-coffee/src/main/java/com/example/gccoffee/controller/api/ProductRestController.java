package com.example.gccoffee.controller.api;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// REST API의 컨트롤러
@RestController  // RestController는 인터페이스 -> 어노테이션 사용 시 자동으로 ResponseBody 가 같이 추가된다.
public class ProductRestController {

    private final ProductService productService;

    // 생성자 주입
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    // 전체 products 조회
    @GetMapping("/api/v1/products")  // 복수형 -> 다건의 product 반환을 알려준다.
    public List<Product> productList(@RequestParam Optional<Category> category) {

        // category 값이 존재하면 -> 람다 fuction 동작
        return category
                .map(productService::getProductsByCategory)
                .orElse(productService.getAllProducts());
    }
}
