package ru.skypro.coursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class BadAmountException extends RuntimeException{

    public BadAmountException(String message) {
        super(message);
    }
}
