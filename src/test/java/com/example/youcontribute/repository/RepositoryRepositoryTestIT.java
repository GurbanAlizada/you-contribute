package com.example.youcontribute.repository;

import com.example.youcontribute.model.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ActiveProfiles(value = "integration")
public class RepositoryRepositoryTestIT {

    @Autowired
    private RepositoryRepository repositoryRepository;

    @Test
    public void itShoultReturnAllRepositories(){

        Repository repository1 = Repository.builder()
                .repository("repository")
                .organization("organization")
                .build();

        Repository repository2 = Repository.builder()
                .repository("repository")
                .organization("organization")
                .build();


        List<Repository> repositoryList = new ArrayList<>();
        repositoryList.add(repository1);
        repositoryList.add(repository2);

        repositoryRepository.saveAll(repositoryList);

        List<Repository> fromDb = repositoryRepository.findAll();

        assertThat(fromDb).isNotNull();
        Assertions.assertEquals(fromDb.get(0).getRepository() , repositoryList.get(0).getRepository());


    }










}