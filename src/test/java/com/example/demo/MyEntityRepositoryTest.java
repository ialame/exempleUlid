package com.example.demo;

import com.example.demo.entity.MyEntity;
import com.example.demo.repository.MyEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MyEntityRepositoryTest {

    @Autowired
    private MyEntityRepository repository;

    @Test
    void testUlidIdsAreSorted() throws InterruptedException {
        // Insère 5 entités
        for (int i = 0; i < 5; i++) {
            repository.save(new MyEntity("Entity " + i));
            Thread.sleep(5); // petite pause pour que les ULID changent légèrement
        }

        // Récupère toutes les entités
        List<MyEntity> entities = repository.findAll();

        // Trie manuellement les UUIDs (ULIDs convertis en UUID)
        List<UUID> idsSorted = entities.stream()
                .map(MyEntity::getId)
                .sorted()
                .toList();

        // Vérifie que l'ordre de la base est le même que trié
        List<UUID> idsOriginal = entities.stream()
                .map(MyEntity::getId)
                .toList();

        assertThat(idsOriginal).isEqualTo(idsSorted);
    }
}
