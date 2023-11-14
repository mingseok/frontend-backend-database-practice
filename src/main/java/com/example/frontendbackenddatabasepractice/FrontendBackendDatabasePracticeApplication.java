package com.example.frontendbackenddatabasepractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.frontendbackenddatabasepractice")
public class FrontendBackendDatabasePracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendBackendDatabasePracticeApplication.class, args);
    }
}