package com.example.youcontribute.dto.resources;


import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RepositoryResource {


    private Integer id;

    private String name;

    private String organization;



}
