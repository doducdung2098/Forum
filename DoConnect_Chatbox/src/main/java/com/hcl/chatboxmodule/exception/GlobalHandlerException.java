package com.hcl.chatboxmodule.exception;

import com.hcl.chatboxmodule.helper.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception ex){
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null ,null);
    }

}
