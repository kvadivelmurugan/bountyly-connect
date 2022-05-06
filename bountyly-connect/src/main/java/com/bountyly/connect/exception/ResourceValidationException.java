package com.bountyly.connect.exception;

public class ResourceValidationException extends RuntimeException {
    public ResourceValidationException(String field, String message){
        super(message);
    }
}
