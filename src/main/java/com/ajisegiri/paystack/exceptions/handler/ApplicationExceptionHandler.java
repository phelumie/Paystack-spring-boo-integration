package com.ajisegiri.paystack.exceptions.handler;
import com.ajisegiri.paystack.exceptions.PayStackExceptions;
import com.ajisegiri.paystack.exceptions.UnAuthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(PayStackExceptions.class)
    public ResponseEntity<Object> accountNotActive(PayStackExceptions payStackException){
        HttpStatus status=HttpStatus.BAD_REQUEST;
        ApiExceptionMessage exception=new ApiExceptionMessage(
                payStackException.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.of("UTC+1")));
        return new ResponseEntity<>(exception,status);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<Object> unauthorizedException(UnAuthorizedException unauthorizedException){
        HttpStatus status=HttpStatus.UNAUTHORIZED;
        ApiExceptionMessage exception=new ApiExceptionMessage(
                unauthorizedException.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.of("UTC+1")));
        return new ResponseEntity<>(exception,status);
    }

}
