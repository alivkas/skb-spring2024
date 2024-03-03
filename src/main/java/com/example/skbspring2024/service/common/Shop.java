package com.example.skbspring2024.service.common;

import com.example.skbspring2024.interfaces.Brokenable;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Shop {
    List<Brokenable> productList = new ArrayList<>();
}
