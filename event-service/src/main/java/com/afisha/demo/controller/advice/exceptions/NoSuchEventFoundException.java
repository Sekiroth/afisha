package com.afisha.demo.controller.advice.exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchEventFoundException extends RuntimeException {

    private String message;

    public NoSuchEventFoundException() {}

    public NoSuchEventFoundException(String message) {
        super(message);
        this.message = message;
    }
}
