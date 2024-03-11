package com.example.skbspring2024.web.controllers;

import com.example.skbspring2024.service.ShopService;
import com.example.skbspring2024.web.dto.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/shop", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopController {
    ShopService shopService;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        shopService.createProduct(product);
        return product;
    }

    @GetMapping("/product")
    public Map<Integer, Product> getProducts() {
        return shopService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return shopService.getProduct(id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id) {
        shopService.deleteProduct(id);
    }
}
