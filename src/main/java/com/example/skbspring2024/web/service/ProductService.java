package com.example.skbspring2024.web.service;

import com.example.skbspring2024.web.dto.Product;
import com.example.skbspring2024.web.errors.NotFoundError;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    List<Product> productList = new CopyOnWriteArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(String name) {
        Product product = productList.stream()
                .filter(x -> name.equals(x.name()))
                .findFirst()
                .orElse(null);

        if (product == null) {
            throw new NotFoundError(name);
        }
        return product;
    }

    public void deleteProduct(String name) {
        Product product = productList.stream()
                .filter(x -> name.equals(x.name()))
                .findFirst()
                .orElse(null);

        if (product == null) {
            throw new NotFoundError(name);
        }
        productList.removeIf(x -> name.equals(x.name()));
    }
}
