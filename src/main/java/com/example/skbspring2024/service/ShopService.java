package com.example.skbspring2024.service;

import com.example.skbspring2024.web.dto.Product;
import com.example.skbspring2024.web.dto.ProductInfo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShopService {
    Map<Integer, Product> productList = new ConcurrentHashMap<>();

    public void createProduct(Product product) {
        int id = new Random().nextInt(0, 1000);
        product.getInfo().setId(id);
        productList.put(id, product);
    }

    public Map<Integer, Product> getProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return new Product(productList.get(id).getPrice(), productList.get(id).getInfo());
    }

    public void deleteProduct(int id) {
        productList.remove(id);
    }
}
