package com.rakesh.RestfulTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestfulTestApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(RestfulTestApplication.class, args);
    }
}
