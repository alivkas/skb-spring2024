package com.example.skbspring2024.service;

import com.example.skbspring2024.interfaces.Brokenable;
import com.example.skbspring2024.service.common.Product;
import com.example.skbspring2024.service.common.Shop;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class DeliveryService {
    Shop shop;
    Brokenable product;
    Brokenable brokenProduct;
    ReceiptService receiptService;

    public void order() {
        receiptService.receipt();
        log.info("{} has ordered", product);
    }

    @PostConstruct
    public void init() {
        log.info("Delivery service created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Delivery service destroyed");
    }
}
