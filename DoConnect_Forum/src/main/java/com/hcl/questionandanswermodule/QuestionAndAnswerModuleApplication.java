package com.hcl.questionandanswermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuestionAndAnswerModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionAndAnswerModuleApplication.class, args);
    }

}
