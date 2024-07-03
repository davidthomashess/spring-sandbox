package com.sandbox.company.service;

import java.time.LocalDate;
import java.util.List;

import com.sandbox.company.entity.Assignment;

public interface AssignmentService {

    List<Assignment> getAssignments();

    Assignment getAssignment(Long employeeId, Long projectId);

    Assignment saveAssignment(LocalDate assignmentDate, Long employeeId, Long projectId);

    void deleteAssignment(Long employeeId, Long projectId);

}
