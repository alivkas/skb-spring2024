package com.example.skbspring2024.service;

import com.example.skbspring2024.service.common.Product;
import com.example.skbspring2024.service.common.Shop;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ReceiptService {
    Shop shop;
    Product product;

    @Autowired
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Autowired
    public void setProduct(Product product) {
        this.product = product;
    }

    public void receipt() {
        shop.addProduct(product);
        log.info("{} receipt", product);
    }

    @PostConstruct
    public void init() {
        log.info("Receipt service created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Receipt service destroyed");
    }
}
