package com.crio.starter.exceptions;

import org.springframework.http.HttpStatus;

public class MemeCollectionException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MemeCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        int statusCode = HttpStatus.NOT_FOUND.value();
        return String.valueOf(statusCode);
    }

    public static String MemeAlreadyExists() {
        return "Meme with given url already exists";
    }
}
