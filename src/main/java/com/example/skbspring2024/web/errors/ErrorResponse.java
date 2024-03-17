package com.example.skbspring2024.web.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(String message, String field, String code) {

    public ErrorResponse(String message, String code) {
        this(message, null, code);
    }
}
