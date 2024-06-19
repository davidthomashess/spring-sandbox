package com.sandbox.company.exception;

public class HourlyEmployeeNotFoundException extends RuntimeException {

    public HourlyEmployeeNotFoundException(Long id) {
        super("The hourly employee id '" + id + "' does not exist in our records");
    }

}
