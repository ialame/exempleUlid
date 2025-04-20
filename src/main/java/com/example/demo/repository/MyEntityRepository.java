package com.example.demo.repository;

import com.example.demo.entity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, String> {
    // JpaRepository fournit déjà les méthodes CRUD de base (save, findById, findAll, deleteById, etc.)
}