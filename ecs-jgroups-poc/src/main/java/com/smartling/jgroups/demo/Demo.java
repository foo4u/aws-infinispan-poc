package com.smartling.jgroups.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Simple Spring Boot app to test JGroups.
 */
@SpringBootApplication
@EnableScheduling
public class Demo {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Demo.class, args);
    }
}
