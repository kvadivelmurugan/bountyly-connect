package com.bountyly.connect.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message){
        super(message);
    }
}
