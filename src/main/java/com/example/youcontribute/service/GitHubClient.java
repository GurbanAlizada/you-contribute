package com.example.youcontribute.service;


import com.example.youcontribute.config.GitHubProperties;
import com.example.youcontribute.dto.resources.GithubIssueResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class GitHubClient {


    private final RestTemplate restTemplate;
    private final GitHubProperties gitHubProperties;

    public GitHubClient(RestTemplate restTemplate, GitHubProperties gitHubProperties) {
        this.restTemplate = restTemplate;
        this.gitHubProperties = gitHubProperties;
    }

    public GithubIssueResponse[] listIssues(String owner , String repository , LocalDate since){

        String issuesUrl = String.format("%s/repos/%s/%s/issues?since=%s" ,
                gitHubProperties.getApiUrl() ,
                owner ,
                repository,
                since.toString());


        HttpHeaders headers = new HttpHeaders();
       // headers.add("Authorization",  "token " + this.gitHubProperties.getToken());
        HttpEntity request = new HttpEntity(headers);


        ResponseEntity<GithubIssueResponse[]> responseEntity =
                restTemplate.exchange(
                        issuesUrl,
                        HttpMethod.GET,
                        request ,
                        GithubIssueResponse[].class);

        return responseEntity.getBody();
    }


}
