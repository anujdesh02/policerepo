package com.example.demo.expection;

public class DuplicateAadharException extends RuntimeException {
    public DuplicateAadharException(String message) {
        super(message);
    }
}
