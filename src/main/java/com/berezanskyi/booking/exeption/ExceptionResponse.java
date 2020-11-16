package com.berezanskyi.booking.exeption;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private HttpStatus status;


}
