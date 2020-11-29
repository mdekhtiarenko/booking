package com.berezanskyi.booking.exeption;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private HttpStatus status; // не знаю чи є якийсь зміст дублювати респонс код в меседжу, бо він у тебе і так буде,
    // але в цілому exception handling зроблений добре


}
