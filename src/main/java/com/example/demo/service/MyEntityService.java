package com.example.demo.service;

import com.example.demo.entity.MyEntity;
import com.example.demo.repository.MyEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyEntityService {

    private final MyEntityRepository myEntityRepository;

    public MyEntityService(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public MyEntity createMyEntity(String name) {
        MyEntity myEntity = new MyEntity();
        myEntity.setName(name);
        return myEntityRepository.save(myEntity);
    }

    public Optional<MyEntity> getMyEntityById(String id) {
        return myEntityRepository.findById(id);
    }

    public List<MyEntity> getAllMyEntities() {
        return myEntityRepository.findAll();
    }

    public void deleteMyEntityById(String id) {
        myEntityRepository.deleteById(id);
    }
}
