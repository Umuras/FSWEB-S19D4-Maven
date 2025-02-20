package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
