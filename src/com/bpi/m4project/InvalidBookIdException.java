package com.bpi.m4project;

public class InvalidBookIdException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidBookIdException(String message) {
        super(message);
    }
}
