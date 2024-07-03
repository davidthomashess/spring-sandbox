package com.sandbox.company.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandbox.company.entity.Assignment;
import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.Project;
import com.sandbox.company.exception.AssignmentNotFoundException;
import com.sandbox.company.exception.DeleteException;
import com.sandbox.company.repository.AssignmentRepository;
import com.sandbox.company.repository.EmployeeRepository;
import com.sandbox.company.repository.ProjectRepository;
import com.sandbox.company.update.AssignmentAssignmentDate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    @Override
    public List<Assignment> getAssignments() {
        return (List<Assignment>) assignmentRepository.findAll();
    }

    @Override
    public Assignment getAssignment(Long employeeId, Long projectId) {
        return assignmentRepository.findByEmployeeIdAndProjectId(employeeId, projectId).get();
    }

    @Override
    public Assignment saveAssignment(LocalDate assignmentDate, Long employeeId,
            Long projectId) {
        Employee employee = EmployeeServiceImpl.unwrapEmployee(employeeRepository.findById(employeeId), employeeId);
        Project project = ProjectServiceImpl.unwrapProject(projectRepository.findById(projectId), projectId);
        Assignment assignment = new Assignment();

        assignment.setEmployee(employee);
        assignment.setProject(project);
        assignment.setAssignmentDate(assignmentDate);

        return assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignment(Long employeeId, Long projectId) {
        Optional<Assignment> assignment = assignmentRepository.findByEmployeeIdAndProjectId(employeeId, projectId);

        if (assignment.isPresent())
            assignmentRepository.deleteByEmployeeIdAndProjectId(employeeId, projectId);
        else
            throw new DeleteException();
    }

    static Assignment unwrapAssignment(Optional<Assignment> entity, Long employeeId, Long projectId) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new AssignmentNotFoundException(employeeId, projectId);
    }

}
