package com.sandbox.company.exception;

import com.sandbox.company.entity.Employee;

public class SalaryEmployeeDataIntegrityException extends RuntimeException {

    public SalaryEmployeeDataIntegrityException(Employee id) {
        super("The employee with id: '" + id + "' is already a salary employee");
    }

}
