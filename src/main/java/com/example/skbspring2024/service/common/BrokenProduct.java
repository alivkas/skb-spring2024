package com.example.skbspring2024.service.common;

import com.example.skbspring2024.interfaces.Brokenable;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class BrokenProduct implements Brokenable {
    String name;
    @ToString.Exclude int id;
}
