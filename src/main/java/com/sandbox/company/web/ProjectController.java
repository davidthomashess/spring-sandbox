package com.sandbox.company.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.company.entity.Project;
import com.sandbox.company.service.ProjectService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getProjects() {
        return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        return new ResponseEntity<>(projectService.getProject(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project) {
        return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProjectName(@Valid @RequestBody Project project, @PathVariable Long id) {
        return new ResponseEntity<>(projectService.updateProjectName(project.getName(), id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProjectStartDate(@Valid @RequestBody Project project, @PathVariable Long id) {
        return new ResponseEntity<>(projectService.updateProjectStartDate(project.getStartDate(), id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProjectEndDate(@Valid @RequestBody Project project, @PathVariable Long id) {
        return new ResponseEntity<>(projectService.updateProjectEndDate(project.getEndDate(), id), HttpStatus.OK);
    }

}
