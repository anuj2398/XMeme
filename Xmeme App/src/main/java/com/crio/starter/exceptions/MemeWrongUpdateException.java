package com.crio.starter.exceptions;

import org.springframework.http.HttpStatus;

public class MemeWrongUpdateException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MemeWrongUpdateException(String message) {
        super(message);
    }

    public static String updationNotAllowedException(String id) {
        int statusCode = HttpStatus.FORBIDDEN.value();
        return String.valueOf(statusCode);
    }
}
