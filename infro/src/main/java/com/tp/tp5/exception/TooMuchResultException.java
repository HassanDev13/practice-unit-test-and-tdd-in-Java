package com.tp.tp5.exception;

public class TooMuchResultException extends Exception {
    public TooMuchResultException(String message) {
        super(message);
    }

    public TooMuchResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
