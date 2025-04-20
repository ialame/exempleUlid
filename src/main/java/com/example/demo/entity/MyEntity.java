package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import com.github.f4b6a3.ulid.UlidCreator;

@Entity
@Data
public class MyEntity {

    @Id
    @GeneratedValue(generator = "ulid")
    @GenericGenerator(name = "ulid", strategy = "com.github.f4b6a3.hibernate.UlidGenerator")
    private String id;
    private String name;

    // ... autres attributs ...

    // ... getters et setters ...
}