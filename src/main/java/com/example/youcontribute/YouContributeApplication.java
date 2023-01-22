package com.example.youcontribute;

import com.example.youcontribute.service.GitHubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
public class YouContributeApplication implements CommandLineRunner {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Autowired
    private GitHubClient client;

    public static void main(String[] args) {
        SpringApplication.run(YouContributeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(client.listIssues("octocat", "Hello-World")[1]);
    }
}
