package com.stackroute.movieservice.exception;

import org.springframework.stereotype.Component;

@Component
public class MovieNotFoundException extends Exception {
    private String message;
    public MovieNotFoundException(){}
    public MovieNotFoundException(String message){
        super(message);
        this.message =message;
    }
}
