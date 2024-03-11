package com.example.skbspring2024.service;

import com.example.skbspring2024.web.dto.Product;
import com.example.skbspring2024.web.dto.ProductInfo;
import com.example.skbspring2024.web.errors.NotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
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
        Product product = productList.get(id);
        if (product == null) {
            throw new NotFoundException(id);
        }
        return new Product(product.getPrice(), product.getInfo());
    }

    public void deleteProduct(int id) {
        if (productList.get(id) == null) {
            throw new NotFoundException(id);
        }
        productList.remove(id);
    }
}
