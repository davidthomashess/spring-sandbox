package com.sandbox.computershop.exception;

public class BrandNotFoundException extends RuntimeException {

    public BrandNotFoundException(Long id) {
        super("The brand id '" + id + "' does not exist in our records");
    }

}
