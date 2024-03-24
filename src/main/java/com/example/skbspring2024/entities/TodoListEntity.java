package com.example.skbspring2024.entities;

import com.example.skbspring2024.common.TodoListRequest;
import com.example.skbspring2024.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todo_list", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TodoListEntity extends BaseEntity {

    @Column(name = "todo_name")
    String name;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL)
    List<EventEntity> events = new ArrayList<>();
}
