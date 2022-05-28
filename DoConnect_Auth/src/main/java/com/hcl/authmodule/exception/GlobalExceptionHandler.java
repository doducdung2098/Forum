package com.hcl.authmodule.exception;

import com.hcl.authmodule.helper.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity duplicatedExceptionHander(DuplicatedException ex){
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null, null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception ex){
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null, null);
    }

}
