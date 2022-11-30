package com.example.youcontribute.service;


import com.example.youcontribute.controller.requests.CreateRepositoryRequest;
import com.example.youcontribute.controller.resources.RepositoryResource;
import com.example.youcontribute.model.Repository;
import com.example.youcontribute.repository.RepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<RepositoryResource> list(){

        List<Repository> fromDb = repositoryRepository.findAll();

        List<RepositoryResource> result = fromDb.stream()
                .map(n->RepositoryResource.builder()
                        .id(n.getId())
                        .name(n.getRepository())
                        .organization(n.getOrganization())
                        .build())
                .collect(Collectors.toList());

        return result;
    }




}
