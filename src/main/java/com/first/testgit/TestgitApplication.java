package com.first.testgit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TestgitApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestgitApplication.class, args);
    }

}
