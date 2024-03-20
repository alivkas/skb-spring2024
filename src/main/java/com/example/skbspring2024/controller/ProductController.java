package com.example.skbspring2024.controller;

import com.example.skbspring2024.common.Product;
import com.example.skbspring2024.service.ProductService;
import com.example.skbspring2024.service.api.ServiceApi;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/shop")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductController {

    ServiceApi productService;

    @GetMapping("/product")
    public Product getProduct() {
        return productService.getProduct();
    }
}
