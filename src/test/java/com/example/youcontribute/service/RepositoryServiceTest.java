package com.example.youcontribute.service;

import com.example.youcontribute.controller.requests.CreateRepositoryRequest;
import com.example.youcontribute.controller.resources.RepositoryResource;
import com.example.youcontribute.model.Repository;
import com.example.youcontribute.repository.RepositoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
public class RepositoryServiceTest {


    private RepositoryRepository repositoryRepository;
    private RepositoryService repositoryService;

    @BeforeEach
    public void setUp(){
        repositoryRepository = Mockito.mock(RepositoryRepository.class);
        repositoryService = new RepositoryService(repositoryRepository);
    }




    @Test
    public void testCreate_itShouldCreateRepository(){

        CreateRepositoryRequest request = CreateRepositoryRequest.builder()
                .organization("test")
                .repository("test")
                .build();

        Repository repository = Repository.builder()
                .organization(request.getOrganization())
                .repository(request.getRepository())
                .build();

        when(repositoryRepository.save(repository)).thenReturn(repository);

        repositoryService.create(request);

        verify(repositoryRepository , times(1)).save(repository);

    }


    @Test
    public void testList_itShouldReturnRepositories(){

        Repository repository1 = Repository.builder()
                .organization("test")
                .repository("test")
                .build();

        Repository repository2 = Repository.builder()
                .organization("test")
                .repository("test")
                .build();

        List<Repository> repositoryList = new ArrayList<>();
        repositoryList.add(repository1);
        repositoryList.add(repository2);

        when(repositoryRepository.findAll()).thenReturn(repositoryList);

        List<RepositoryResource> result = repositoryService.list();
        assertEquals(result.get(0).getOrganization() , repositoryList.get(0).getOrganization());
        verify(repositoryRepository , times(1)).findAll();
    }






}