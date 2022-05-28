package com.hcl.questionandanswermodule.exception;

public class DuplicatedException extends RuntimeException{
    public DuplicatedException(String message){
        super(message);
    }
}
