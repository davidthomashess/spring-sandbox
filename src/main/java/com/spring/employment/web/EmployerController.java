package com.spring.employment.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employment.entity.Employee;
import com.spring.employment.entity.Employer;
import com.spring.employment.service.EmployerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employer")
public class EmployerController {

    EmployerService employerService;

    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable Long id) {
        return new ResponseEntity<>(employerService.getEmployer(id), HttpStatus.OK)
    }

    @PostMapping
    public ResponseEntity<Employer> saveEmployer(@Valid @RequestBody Employer employer) {
        return new ResponseEntity<>(employerService.saveEmployer(employer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employer>> getEmployers() {
        return new ResponseEntity<>(employerService.getEmployers(), HttpStatus.OK);
    }

    @PutMapping("/{employerId}/employee/{employeeId}")
    public ResponseEntity<Employer> addEmployeeToEmployer(@PathVariable Long employerId,
            @PathVariable Long employeeId) {
        return new ResponseEntity<>(employerService.addEmployeeToEmployer(employeeId, employerId), HttpStatus.OK);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<Set<Employee>> getEmployedEmployees(@PathVariable Long id) {
        return new ResponseEntity<>(employerService.getEmployedEmployees(id), HttpStatus.OK);
    }

}
