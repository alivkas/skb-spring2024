package com.example.skbspring2024.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "shop")
public class ShopProperties {
    List<String> products;
    String name;
    String env;
}
