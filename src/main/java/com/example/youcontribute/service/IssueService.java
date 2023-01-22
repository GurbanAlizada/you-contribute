package com.example.youcontribute.service;


import com.example.youcontribute.model.Issue;
import com.example.youcontribute.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {


    private final IssueRepository issueRepository;



    @Transactional
    public void saveAll(List<Issue> issueList){
        issueRepository.saveAll(issueList);
    }



}
