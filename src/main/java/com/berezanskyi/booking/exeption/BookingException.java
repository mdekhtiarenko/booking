package com.berezanskyi.booking.exeption;

import org.springframework.http.HttpStatus;


public class BookingException extends RuntimeException {
    private HttpStatus status;

    public BookingException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }



}
