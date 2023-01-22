package com.example.youcontribute.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


    @Configuration
    @ConfigurationProperties("github")
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public  class GitHubProperties{


        private String apiUrl;

        private String token;

    }



