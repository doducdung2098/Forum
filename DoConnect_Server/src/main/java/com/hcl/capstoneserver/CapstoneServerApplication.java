package com.hcl.capstoneserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CapstoneServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapstoneServerApplication.class, args);
    }

}
