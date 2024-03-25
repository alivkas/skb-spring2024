package com.example.skbspring2024.service;

import com.example.skbspring2024.common.TodoListUserData;
import com.example.skbspring2024.entities.EventEntity;
import com.example.skbspring2024.entities.TodoListEntity;
import com.example.skbspring2024.repositories.TodoListRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TodoListService {

    TodoListRepository todoListRepository;

    public void createTodoList(TodoListUserData userData) {
        TodoListEntity todo = new TodoListEntity();
        todo.setName(userData.getName());

        for (String eventName : userData.getEvents()) {
            EventEntity event = new EventEntity();
            event.setName(eventName);
            event.setTodoList(todo);
            todo.getEvents().add(event);
        }

        todoListRepository.save(todo);
    }

    public List<TodoListUserData> getTodoLists() {
        List<TodoListUserData> result = new ArrayList<>();
        for (TodoListEntity todo : todoListRepository.findAll()) {
            result.add(new TodoListUserData(todo));
        }

        return result;
    }
}
