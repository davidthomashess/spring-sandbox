package com.sandbox.company.exception;

public class EmployeeWithoutAssignmentException extends RuntimeException {

    public EmployeeWithoutAssignmentException(Long employeeId, Long projectId) {
        super("The employee with id: " + employeeId + "' has not been given the assignment with project id:'"
                + projectId);
    }

}
