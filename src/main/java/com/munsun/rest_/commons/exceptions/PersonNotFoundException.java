package com.munsun.rest_.commons.exceptions;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(int id) {
        super("Person not found! id="+id);
    }
}
