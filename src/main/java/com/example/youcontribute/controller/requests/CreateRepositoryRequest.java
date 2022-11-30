package com.example.youcontribute.controller.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRepositoryRequest {


    @NotBlank
    private String organization;

    @NotBlank
    private String repository;



}
