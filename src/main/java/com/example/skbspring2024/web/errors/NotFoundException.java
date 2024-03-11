package com.example.skbspring2024.web.errors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotFoundException extends RuntimeException {
    String code = "NOT_FOUND";

    public NotFoundException(int id){
        super("Not found: " + id);
    }
}
