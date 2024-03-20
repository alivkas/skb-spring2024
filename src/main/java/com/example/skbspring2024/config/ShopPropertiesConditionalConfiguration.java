package com.example.skbspring2024.config;

import com.example.skbspring2024.common.Product;
import com.example.skbspring2024.config.property.ShopProperties;
import com.example.skbspring2024.service.ProductService;
import com.example.skbspring2024.service.api.ServiceApi;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

import static com.example.skbspring2024.common.Profile.*;


@Log4j2
@Configuration
@EnableConfigurationProperties(ShopProperties.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShopPropertiesConditionalConfiguration {

    @Bean
    @Profile(TEST)
    public ResponseEntity<String> beanTestProfile() {
        log.info("Test work");
        return ResponseEntity.ok("ok");
    }

    @Bean
    @ConditionalOnBean(ResponseEntity.class)
    public ResponseEntity<String> beanAfterTest() {
        log.info("Work after test");
        return ResponseEntity.ok("ok");
    }

    @Bean
    @ConditionalOnProperty(name = "EXAMPLE_TEST", havingValue = "default", matchIfMissing = true)
    public ResponseEntity<String> beanWithoutDefaultEnvVal() {
        log.info("env not default");
        return ResponseEntity.ok("ok");
    }
}
