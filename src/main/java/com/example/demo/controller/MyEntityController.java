package com.example.demo.controller;

import com.example.demo.entity.MyEntity;
import com.example.demo.service.MyEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/my-entities")
public class MyEntityController {

    private final MyEntityService myEntityService;

    public MyEntityController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    @PostMapping
    public ResponseEntity<MyEntity> createMyEntity(@RequestParam String name) {
        MyEntity createdEntity = myEntityService.createMyEntity(name);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntity> getMyEntityById(@PathVariable String id) {
        Optional<MyEntity> myEntity = myEntityService.getMyEntityById(id);
        return myEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<MyEntity>> getAllMyEntities() {
        List<MyEntity> allEntities = myEntityService.getAllMyEntities();
        return new ResponseEntity<>(allEntities, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyEntityById(@PathVariable String id) {
        myEntityService.deleteMyEntityById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}