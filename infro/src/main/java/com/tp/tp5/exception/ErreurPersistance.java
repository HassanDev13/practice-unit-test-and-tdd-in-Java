package com.tp.tp5.exception;

public class ErreurPersistance extends Exception {
    public ErreurPersistance(String message) {
        super(message);
    }

    public ErreurPersistance(String message, Throwable cause) {
        super(message, cause);
    }
}