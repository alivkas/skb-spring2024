package com.example.skbspring2024.controllers;

import com.example.skbspring2024.common.TodoListUserData;
import com.example.skbspring2024.common.Message;
import com.example.skbspring2024.service.TodoListService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TodoListController {

    TodoListService todoListService;

    @PostMapping
    public Message createTodoList(@RequestBody TodoListUserData userData) {
        todoListService.createTodoList(userData);
        return Message.getCreateMessage();
    }

    @GetMapping
    public List<TodoListUserData> getAllLists() {
        return todoListService.getTodoLists();
    }
}
