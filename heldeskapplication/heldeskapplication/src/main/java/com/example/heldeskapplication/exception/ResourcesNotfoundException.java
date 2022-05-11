package com.example.heldeskapplication.exception;

public class ResourcesNotfoundException extends RuntimeException{
    public ResourcesNotfoundException(String message){
        super(message);
    }
}