package com.spring.employment.exception;

public class EmployerNotFoundException extends RuntimeException {

    public EmployerNotFoundException(Long id) {
        super("The employer id '" + id + "' does not exist in our records");
    }

}
