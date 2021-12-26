package com.example.test11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yaml")
public class Test11Application {
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.driver-class-name}")
    private static String driver;

    public static void main(String[] args) {
        System.out.println("-------- app started ---------");
        System.out.println("-------- url ---------" + url);
        System.out.println("-------- driver ---------" + driver);
        SpringApplication.run(Test11Application.class, args);
    }
}
