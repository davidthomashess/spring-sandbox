package com.sandbox.company.exception;

public class EmployeeDataIntegrityException extends RuntimeException {

    public EmployeeDataIntegrityException(Long id) {
        super("The employee with id: '" + id + "' already exists");
    }

}
