package com.example.demo.entity;

import com.github.f4b6a3.hibernate.AbstractUlidEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import com.github.f4b6a3.ulid.UlidCreator;

import java.util.UUID;

@Entity
public class MyEntity extends AbstractUlidEntity {
    private String name;
    public MyEntity(String name) {
        super();
        this.name = name;
    }
    public MyEntity() {
    }

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
