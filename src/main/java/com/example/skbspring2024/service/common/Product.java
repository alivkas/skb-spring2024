package com.example.skbspring2024.service.common;

import com.example.skbspring2024.interfaces.Brokenable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Product implements Brokenable {
    private String name;
    private int id;

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
