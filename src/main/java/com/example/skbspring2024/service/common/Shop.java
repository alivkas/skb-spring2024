package com.example.skbspring2024.service.common;

import com.example.skbspring2024.interfaces.Brokenable;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Brokenable> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProduct(Product product) {
        int index = product.getId();
        productList.remove(index);
    }
}
