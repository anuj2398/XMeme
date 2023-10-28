package com.crio.starter.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidUrlException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidUrlException(String message) {
        super(message);
    }

    public static String wrongUrlException() {
        int statusCode = HttpStatus.NOT_ACCEPTABLE.value();
        return String.valueOf(statusCode);
    }
}
