package com.example.skbspring2024.config;

import com.example.skbspring2024.service.common.BrokenProduct;
import com.example.skbspring2024.service.common.Product;
import com.example.skbspring2024.service.common.Shop;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Log4j2
@Configuration
public class ShopConfig {
    @Bean
    @Scope(value = "singleton")
    public Shop shop() {
        return new Shop();
    }

    @Bean
    @Scope(value = "singleton")
    public Product product() {
        return new Product();
    }

    @Bean
    @Scope(value = "singleton")
    public BrokenProduct brokenProduct() {
        return new BrokenProduct();
    }
}
