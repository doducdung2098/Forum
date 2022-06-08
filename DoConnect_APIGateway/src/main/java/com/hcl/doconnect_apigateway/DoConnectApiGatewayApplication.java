package com.hcl.doconnect_apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DoConnectApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoConnectApiGatewayApplication.class, args);
    }

}
