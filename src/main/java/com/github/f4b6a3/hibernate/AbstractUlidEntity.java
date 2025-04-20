package com.github.f4b6a3.hibernate;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class AbstractUlidEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id= UlidCreator.getUlid().toUuid(); // ➔ Un ULID, stocké comme UUID

    public AbstractUlidEntity() {
        this.id = UlidCreator.getUlid().toUuid(); // ➔ Un ULID, stocké comme UUID
    }

    // Getters & Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}