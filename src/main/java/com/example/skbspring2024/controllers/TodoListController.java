package com.example.skbspring2024.controllers;

import com.example.skbspring2024.common.TodoListRequest;
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
    public void createTodoList(@RequestBody TodoListRequest request) {
        todoListService.createTodoList(request);
    }

    @GetMapping
    public List<TodoListRequest> getAllLists() {
        return todoListService.getTodoLists();
    }
}
