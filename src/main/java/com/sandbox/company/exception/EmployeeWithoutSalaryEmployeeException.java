package com.sandbox.company.exception;

public class EmployeeWithoutSalaryEmployeeException extends RuntimeException {

    public EmployeeWithoutSalaryEmployeeException(Long employeeId) {
        super("The employee with id: " + employeeId + "' is not a salary employee'");
    }

}
