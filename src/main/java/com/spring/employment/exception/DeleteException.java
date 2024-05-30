package com.spring.employment.exception;

public class DeleteException extends RuntimeException {

    public DeleteException() {
        super("Cannot delete non-existing resource");
    }

}
