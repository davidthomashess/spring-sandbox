package com.sandbox.company.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("The employee id: '" + id + "' does not exist in our records");
    }

}
