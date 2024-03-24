package com.example.skbspring2024.repositories;

import com.example.skbspring2024.entities.TodoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoListEntity, Long> {
}
