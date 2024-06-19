package com.sandbox.company.exception;

public class AssignmentNotFoundException extends RuntimeException {

    public AssignmentNotFoundException(Long employeeId, Long projectId) {
        super("The employee with the id: '" + employeeId + "' has not been assigned to the project with an id of: '"
                + projectId);
    }

}
