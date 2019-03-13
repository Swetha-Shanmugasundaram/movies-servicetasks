package com.stackroute.movieservice.exception;

import org.springframework.stereotype.Component;

@Component
public class MovieAlreadyExistsException extends Exception {
    private String message;
    public MovieAlreadyExistsException(){}
    public MovieAlreadyExistsException(String message){
        super(message);
        this.message =message;
    }
}
