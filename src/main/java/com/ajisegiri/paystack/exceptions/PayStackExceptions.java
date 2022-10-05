package com.ajisegiri.paystack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PayStackExceptions extends RuntimeException {
    public PayStackExceptions(String message) {
        super(message);
    }
}
