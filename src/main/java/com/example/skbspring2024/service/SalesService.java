package com.example.skbspring2024.service;

import com.example.skbspring2024.interfaces.Brokenable;
import com.example.skbspring2024.service.common.Product;
import com.example.skbspring2024.service.common.Shop;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesService {
    @Autowired
    Brokenable product;
    @Autowired
    Brokenable brokenProduct;
    @Autowired
    Shop shop;


    @PostConstruct
    public void init() {
        log.info("Sales service created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Sales service destroyed");
    }
}
