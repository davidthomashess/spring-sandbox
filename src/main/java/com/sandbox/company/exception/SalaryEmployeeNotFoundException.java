package com.sandbox.company.exception;

public class SalaryEmployeeNotFoundException extends RuntimeException {

    public SalaryEmployeeNotFoundException(Long id) {
        super("The salary employee id '" + id + "' does not exist in our records");
    }

}
