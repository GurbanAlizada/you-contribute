package com.example.youcontribute;

import com.example.youcontribute.service.GitHubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
public class YouContributeApplication implements CommandLineRunner {



    @Autowired
    private GitHubClient client;

    public static void main(String[] args) {
        SpringApplication.run(YouContributeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      //  System.out.println(client.listIssues("octocat", "Hello-World" , LocalDate.of(2013,01,01))[1]);
    }



}
