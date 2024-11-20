package com.example.esdlabactivities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EsdLabActivitiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdLabActivitiesApplication.class, args);
    }

}
