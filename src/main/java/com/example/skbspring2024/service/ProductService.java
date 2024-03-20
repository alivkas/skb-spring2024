package com.example.skbspring2024.service;

import com.example.skbspring2024.common.Product;
import com.example.skbspring2024.service.api.ServiceApi;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService implements ServiceApi {

    Product product;

    @Override
    public Product getProduct() {
        return product;
    }
}
