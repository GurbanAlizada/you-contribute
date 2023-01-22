package com.example.youcontribute.scheduler;


import com.example.youcontribute.manager.RepositoryManager;
import com.example.youcontribute.model.Repository;
import com.example.youcontribute.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ImportIssueScheduler {


    private final RepositoryService repositoryService;
    private final RepositoryManager repositoryManager;


    @Scheduled(fixedRateString = "${application.import-frequency}" , initialDelay = 60000)
    public void importIssueScheduler(){

        log.info("Scheduler started");


        List<Repository> list = repositoryService.list();
        list.stream().forEach(repo->repositoryManager.importIssues(repo));


        log.info("Scheduler finished");


    }

}
