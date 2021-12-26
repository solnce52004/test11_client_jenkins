package com.example.test11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test11Application {
    @Value("${spring.datasource.url}")
    private static String url;

    public static void main(String[] args) {
        System.out.println("-------- app started ---------");
        System.out.println("-------- spring.datasource.url ---------" + url);
        SpringApplication.run(Test11Application.class, args);
    }
}
