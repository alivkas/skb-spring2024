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

@Service
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptService {
    Shop shop;
    Brokenable product;
    Brokenable brokenProduct;

    @Autowired
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Autowired
    public void setProduct(Brokenable product) {
        this.product = product;
    }

    @Autowired
    public void setBrokenProduct(Brokenable brokenProduct) {
        this.brokenProduct = brokenProduct;
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
