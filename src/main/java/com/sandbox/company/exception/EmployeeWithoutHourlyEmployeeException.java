package com.sandbox.company.exception;

public class EmployeeWithoutHourlyEmployeeException extends RuntimeException {

    public EmployeeWithoutHourlyEmployeeException(Long employeeId) {
        super("The employee with id: " + employeeId + "' is not an hourly employee'");
    }

}
