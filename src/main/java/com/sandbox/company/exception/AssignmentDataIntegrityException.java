package com.sandbox.company.exception;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.Project;

public class AssignmentDataIntegrityException extends RuntimeException {

    public AssignmentDataIntegrityException(Employee employeeId, Project projectId) {
        super("The employee with id: '" + employeeId
                + "' has already been assigned to the project with the following id: '" + projectId);
    }

}
