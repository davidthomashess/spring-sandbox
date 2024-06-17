package com.sandbox.company.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.company.entity.Assignment;
import com.sandbox.company.service.AssignmentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    private AssignmentService assignmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> getAssignments() {
        return new ResponseEntity<>(assignmentService.getAssignments(), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}/project/{projectId}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable Long employeeId, @PathVariable Long projectId) {
        return new ResponseEntity<>(assignmentService.getAssignment(employeeId, projectId), HttpStatus.OK);
    }

    @PostMapping("/employee/{employeeId}/project/{projectId}")
    public ResponseEntity<Assignment> saveAssignment(@Valid @RequestBody Assignment assignment,
            @PathVariable Long employeeId, @PathVariable Long projectId) {
        return new ResponseEntity<>(assignmentService.saveAssignment(assignment, employeeId, projectId),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{employeeId}/project/{projectId}")
    public ResponseEntity<HttpStatus> deleteAssignment(@PathVariable Long employeeId, @PathVariable Long projectId) {
        assignmentService.deleteAssignment(employeeId, projectId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
