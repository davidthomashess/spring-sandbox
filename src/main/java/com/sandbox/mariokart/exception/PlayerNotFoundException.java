package com.sandbox.mariokart.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(Long id) {
        super("The player id '" + id + "' does not exist in our records");
    }

}
