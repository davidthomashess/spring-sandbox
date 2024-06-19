package com.sandbox.company.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super("The project id: '" + id + "' does not exist in our records");
    }

}
