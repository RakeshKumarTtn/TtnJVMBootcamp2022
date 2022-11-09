package org.ttn.sprintrest2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/*
    Since I used the springfox dependency that's why SwaggerConfig file needed to be created
    another way was to add dependency:
        <groupId> org.springdoc</groupId>
        <artifactId> springdoc-openapi-starter-webmvc-ui</artifactId>
        <version> 2.0.0-RC1 </version>

     This version was the sole reason which caused a lot of errors
     now the tweak which we have to do everytime we have some sort of
     update for swagger.
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Assignment Spring REST 2",
                "1.0",
                "@Rakesh",
                new Contact("Rakesh Kumar", "www.tothenew.com", "rakesh.kumar3@tothenew.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
