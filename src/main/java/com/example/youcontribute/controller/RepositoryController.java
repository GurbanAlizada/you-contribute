package com.example.youcontribute.controller;


import com.example.youcontribute.dto.requests.CreateRepositoryRequest;
import com.example.youcontribute.dto.resources.RepositoryResource;
import com.example.youcontribute.service.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repositories")
public class RepositoryController {


    private final RepositoryService service;

    public RepositoryController(RepositoryService service) {
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CreateRepositoryRequest request){
        service.create(request);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RepositoryResource> list(){
        return service.list()
                .stream()
                .map(n->RepositoryResource.builder()
                        .organization(n.getOrganization())
                        .name(n.getRepository())
                        .id(n.getId()).build())
                .collect(Collectors.toList());
    }



}
