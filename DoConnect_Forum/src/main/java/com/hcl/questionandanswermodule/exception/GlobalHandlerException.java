package com.hcl.questionandanswermodule.exception;

import com.hcl.questionandanswermodule.helper.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handlerInvalidInputException(InvalidInputException ex){
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null, null);
    }

    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity handlerDuplicatedException(DuplicatedException ex){
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null, null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception ex){
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null ,null);
    }
}
