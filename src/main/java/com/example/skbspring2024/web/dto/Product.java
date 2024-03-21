package com.example.skbspring2024.web.dto;

import com.example.skbspring2024.web.validation.ExpensiveBrokenConstraint;
import com.example.skbspring2024.web.validation.UnionValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@ExpensiveBrokenConstraint
public record Product(@NotNull boolean isBroken,
                      @NotBlank @NotNull String name,
                      @UnionValidation int count,
                      @Positive int price) {
}
