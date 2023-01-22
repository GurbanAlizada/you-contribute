package com.example.youcontribute.manager;


import com.example.youcontribute.dto.requests.CreateRepositoryRequest;
import com.example.youcontribute.model.Issue;
import com.example.youcontribute.model.Repository;
import com.example.youcontribute.service.GitHubClient;
import com.example.youcontribute.service.IssueService;
import com.example.youcontribute.service.RepositoryService;
import com.example.youcontribute.dto.resources.GithubIssueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepositoryManager {

    private final RepositoryService repositoryService;
    private final GitHubClient client;
    private final IssueService service;



    public void importRepository(String organization , String repository){
        CreateRepositoryRequest request = CreateRepositoryRequest.builder()
                .repository(repository)
                .organization(organization)
                .build();
        this.repositoryService.create(request);
    }



    @Async
    public void importIssues(Repository repository){
        LocalDate since = LocalDate.ofInstant(Instant.now().minus(1, ChronoUnit.DAYS), ZoneId.systemDefault());

        GithubIssueResponse[] githubIssueResponses =
                this.client.listIssues(repository.getOrganization() ,
                        repository.getRepository() , since);


        if (githubIssueResponses.length > 0 ){
            List<Issue> issues = Arrays.stream(githubIssueResponses).map(n ->  Issue.builder().title(n.getTitle()).body(n.getBody()).url(n.getRepositoryUrl()).build()).collect(Collectors.toList());
            this.service.saveAll(issues);
        }



    }




}
