package com.example.skbspring2024.common;

import com.example.skbspring2024.entities.EventEntity;
import com.example.skbspring2024.entities.TodoListEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class TodoListUserData {
    String name;
    List<String> events;

    public TodoListUserData(TodoListEntity todo) {
        this.name = todo.getName();
        List<EventEntity> events = todo.getEvents();
        List<String> result = new ArrayList<>();

        for (EventEntity e : events) {
            result.add(e.getName());
        }

        this.events = result;
    }
}
