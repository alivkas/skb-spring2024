package com.example.skbspring2024.entities.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
@FieldNameConstants(innerTypeName = "BaseFields")
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    Long id;
}
