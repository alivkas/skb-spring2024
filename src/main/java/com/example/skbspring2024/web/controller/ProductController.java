package com.example.skbspring2024.web.controller;

import com.example.skbspring2024.web.dto.Message;
import com.example.skbspring2024.web.dto.Product;
import com.example.skbspring2024.web.service.MessageService;
import com.example.skbspring2024.web.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping(value = "/api/shop", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    ProductService productService;
    MessageService messageService;

    @PostMapping("/product")
    public Message addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
        return messageService.getCreateMessage(product.name());
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProduct(name);
    }

    @DeleteMapping("/product/{name}")
    public Message deleteProduct(@PathVariable String name) {
        productService.deleteProduct(name);
        return messageService.getDeleteMessage(name);
    }
}
