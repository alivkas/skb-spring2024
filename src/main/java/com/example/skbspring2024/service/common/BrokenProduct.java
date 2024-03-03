package com.example.skbspring2024.service.common;

import com.example.skbspring2024.interfaces.Brokenable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrokenProduct implements Brokenable {
    private String name;
    private int id;
    @Override
    public boolean isBroken() {
        return true;
    }
}
