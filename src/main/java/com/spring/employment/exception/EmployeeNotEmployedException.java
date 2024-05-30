package com.spring.employment.exception;

public class EmployeeNotEmployedException extends RuntimeException {

    public EmployeeNotEmployedException(Long employeeId, Long employerId) {
        super("The employeeId with id: '" + employeeId + "' is not enrolled in the course with id: '" + employerId);
    }

}
