package com.example.skbspring2024.web.validation;

import com.example.skbspring2024.web.dto.Product;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ExpensiveBrokenValidator implements ConstraintValidator<ExpensiveBrokenConstraint, Product> {

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        return !product.isBroken() || product.price() < 1000;
    }
}
