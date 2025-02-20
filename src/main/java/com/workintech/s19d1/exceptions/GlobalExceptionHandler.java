package com.workintech.s19d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleException(ApiException apiException)
    {
        ApiErrorResponse errorResponse = new ApiErrorResponse(apiException.getHttpStatus().value(), apiException.getMessage(),
                System.currentTimeMillis());
        log.error("Error occured",errorResponse);
        return new ResponseEntity<ApiErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception)
    {
        ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<ApiErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
