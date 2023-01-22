package com.example.youcontribute.dto.requests;


import lombok.*;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRepositoryRequest {


    @NotBlank
    private String organization;

    @NotBlank
    private String repository;



}
