package com.example.youcontribute.service;


import com.example.youcontribute.dto.requests.CreateRepositoryRequest;
import com.example.youcontribute.model.Repository;
import com.example.youcontribute.repository.RepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepositoryService {


    private final RepositoryRepository repositoryRepository;


    @Transactional
    public void create(CreateRepositoryRequest request) {

        Repository repository = Repository.builder()
                .repository(request.getRepository())
                .organization(request.getOrganization())
                .build();

        repositoryRepository.save(repository);

    }


    public List<Repository> list(){

        List<Repository> fromDb = repositoryRepository.findAll();


        return fromDb;
    }




}
