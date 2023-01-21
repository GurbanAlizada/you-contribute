package com.example.youcontribute.service;


import com.example.youcontribute.config.GitHubProperties;
import com.example.youcontribute.service.response.GithubIssueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GitHubClient {


    private final RestTemplate restTemplate;
    private final GitHubProperties gitHubProperties;

    public GithubIssueResponse listIssues(String owner , String repository){

        String issuesUrl = String.format("%s/repos/%s/%s/issues" ,
                gitHubProperties.getApiUrl() ,
                owner ,
                repository);

        ResponseEntity<GithubIssueResponse> responseEntity =
                restTemplate.exchange(
                        issuesUrl,
                        HttpMethod.GET,
                        null ,
                        GithubIssueResponse.class);
        return null;
    }


}
