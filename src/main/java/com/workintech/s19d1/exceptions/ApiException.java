package com.workintech.s19d1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Getter
public class ApiException extends RuntimeException{
    private HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus)
    {
        super(message);
        this.httpStatus = httpStatus;
    }
}
