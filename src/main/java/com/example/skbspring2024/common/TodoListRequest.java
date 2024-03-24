package com.example.skbspring2024.common;

import com.example.skbspring2024.entities.EventEntity;
import com.example.skbspring2024.entities.TodoListEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class TodoListRequest {
    String name;
    List<String> events;

    public TodoListRequest(TodoListEntity todo) {
        this.name = todo.getName();
        List<EventEntity> events = todo.getEvents();
        List<String> result = new CopyOnWriteArrayList<>();

        for (EventEntity e : events) {
            result.add(e.getName());
        }

        this.events = result;
    }
}