package com.example.skbspring2024.service;

import com.example.skbspring2024.web.dto.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShopService {
    List<Product> productList = new ArrayList<>();

    public void createProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    public void deleteProduct(int index) {
        productList.remove(index);
    }
}
