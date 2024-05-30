package com.spring.employment.exception;

public class EmployeeDataIntegrityException extends RuntimeException {

    public EmployeeDataIntegrityException(Long employeeId, Long employerId) {
        super("The employee with id: '" + employeeId + "' is already enrolled in the course with id: '" + employerId);
    }

}
