package com.munsun.rest_.web.advice;

import com.munsun.rest_.commons.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonAdvice {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Response> handleException(PersonNotFoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }
}

