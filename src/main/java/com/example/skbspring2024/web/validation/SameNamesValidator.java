package com.example.skbspring2024.web.validation;

import com.example.skbspring2024.web.dto.Product;
import com.example.skbspring2024.web.service.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SameNamesValidator implements ConstraintValidator<SameNamesConstraint, Product> {

    ProductService productService;

    @SneakyThrows
    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        List<Product> products = productService.getProducts();
        for (Product p : products) {
            Field field = Product.class.getDeclaredField("name");
            field.setAccessible(true);

            String productName = (String) field.get(product);
            String serviceProductName = (String) field.get(p);

            if (productName != null && productName.equals(serviceProductName)) {
                return false;
            }
        }
        return true;
    }
}
