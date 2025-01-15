package com.example.disco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoApplication.class, args);
    }

}
