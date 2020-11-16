package com.berezanskyi.booking.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionHandler {

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(BookingException ex){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getStatus() );
        return new ResponseEntity<>(response, response.getStatus());
    }

}


