package com.example.skbspring2024.entities;

import com.example.skbspring2024.entities.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "event", schema = "public")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EventEntity extends BaseEntity {

    @Column(name = "event_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    @JsonIgnore
    TodoListEntity todoList;
}
