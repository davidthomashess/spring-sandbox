package com.sandbox.mariokart.exception;

public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(Long id) {
        super("The track id '" + id + "' does not exist in our records");
    }

}
