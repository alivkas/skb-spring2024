package com.example.skbspring2024.config;

import com.example.skbspring2024.common.Product;
import com.example.skbspring2024.config.property.ShopProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static com.example.skbspring2024.common.Profile.DEV;


@Profile(DEV)
@Configuration
@EnableConfigurationProperties(ShopProperties.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShopPropertiesConfigurationDev {

    ShopProperties shopProperties;

    @Bean
    public Product product() {
        Product product = new Product();
        product.setProducts(shopProperties.getProducts());
        product.setName(shopProperties.getName());
        return product;
    }
}
