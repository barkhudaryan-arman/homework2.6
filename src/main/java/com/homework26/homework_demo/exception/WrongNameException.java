package com.homework26.homework_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongNameException extends RuntimeException {
    public WrongNameException() {
    }

    public WrongNameException(String message) {
        super(message);
    }

    public WrongNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongNameException(Throwable cause) {
        super(cause);
    }

    public WrongNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
