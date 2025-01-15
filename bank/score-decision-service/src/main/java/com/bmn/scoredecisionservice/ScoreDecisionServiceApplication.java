package com.bmn.scoredecisionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ScoreDecisionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreDecisionServiceApplication.class, args);
    }

}
