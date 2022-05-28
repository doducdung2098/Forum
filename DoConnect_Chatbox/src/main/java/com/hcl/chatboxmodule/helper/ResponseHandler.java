package com.hcl.chatboxmodule.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, String dataName, Object response){
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", status.value());
        if(response != null) {
            map.put(dataName, response);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-cache");
        return new ResponseEntity<>(map, headers, status);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    };
}

