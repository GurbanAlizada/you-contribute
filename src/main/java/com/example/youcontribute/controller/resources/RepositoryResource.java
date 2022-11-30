package com.example.youcontribute.controller.resources;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class RepositoryResource {


    private Integer id;

    private String name;

    private String organization;



}
