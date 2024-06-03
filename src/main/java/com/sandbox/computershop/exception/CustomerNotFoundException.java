package com.sandbox.computershop.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("The student id '" + id + "' does not exist in our records");
    }

}
