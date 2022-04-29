package com.example.companywebsite.exception;

import com.example.companywebsite.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handlerNotfound(NotFoundException e) {
        return new ResponseEntity<>(new RestResponse.Success()
                .setMessage(e.getMessage())
                .setStatus(HttpStatus.NOT_FOUND.value())
                .build()
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity handlerDuplicate(DuplicateException e) {
        return new ResponseEntity(new RestResponse.Success()
                .setMessage(e.getMessage())
                .setStatus(HttpStatus.CONFLICT.value())
                .build(), HttpStatus.CONFLICT);
    }


}
