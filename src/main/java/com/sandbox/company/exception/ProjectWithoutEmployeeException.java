package com.sandbox.company.exception;

public class ProjectWithoutEmployeeException extends RuntimeException {

    public ProjectWithoutEmployeeException(Long projectId, Long employeeId) {
        super("The project with id: '" + projectId + "' has not been assigned to employee with id: '" + employeeId
                + "'");
    }

}
