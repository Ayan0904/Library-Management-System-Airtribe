package org.example.CustomException;

public class PatronNotFoundException extends Exception {

    public PatronNotFoundException(String message) {
        super(message);
    }
}