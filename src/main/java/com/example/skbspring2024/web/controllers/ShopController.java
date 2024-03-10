package com.example.skbspring2024.web.controllers;

import com.example.skbspring2024.service.ShopService;
import com.example.skbspring2024.web.dto.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        int id = new Random().nextInt(0, 1000);
        product.info().setId(id);
        shopService.createProduct(product);
        return product;
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return shopService.getProducts();
    }

    @GetMapping("/product/{index}")
    public Product getProduct(@PathVariable int index) {
        return shopService.getProduct(index);
    }

    @DeleteMapping("/product/{index}")
    public void deleteProduct(@PathVariable int index) {
        shopService.deleteProduct(index);
    }
}
