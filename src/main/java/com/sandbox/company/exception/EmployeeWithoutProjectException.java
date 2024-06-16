package com.sandbox.company.exception;

public class EmployeeWithoutProjectException extends RuntimeException {

    public EmployeeWithoutProjectException(Long employeeId) {
        super("The employee with id: " + employeeId + "' is not setup with that phone number'");
    }

}
