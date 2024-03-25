package com.example.skbspring2024.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
public class Message {
    String name;
    String status;

    public static Message getCreateMessage() {
        return new Message("Succes", "Created");
    }
}
