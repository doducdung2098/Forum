package com.hcl.questionandanswermodule.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}
