package com.example.skbspring2024.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = SameNamesValidator.class)
public @interface SameNamesConstraint {

    String message() default "{product.samenames.not_valid}";

    Class<?>[] groups() default  {};

    Class<? extends Payload>[] payload() default {};
}
