package com.sandbox.mariokart.exception;

public class DeleteException extends RuntimeException {

    public DeleteException() {
        super("Cannot delete non-existing resource");
    }

}
