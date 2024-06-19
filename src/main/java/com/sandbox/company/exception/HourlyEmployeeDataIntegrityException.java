package com.sandbox.company.exception;

import com.sandbox.company.entity.Employee;

public class HourlyEmployeeDataIntegrityException extends RuntimeException {

    public HourlyEmployeeDataIntegrityException(Employee id) {
        super("The employee with id: '" + id + "' is already an hourly employee");
    }

}
