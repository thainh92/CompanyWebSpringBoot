package com.example.companywebsite.exception;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message){
        super(message);
    }
}
