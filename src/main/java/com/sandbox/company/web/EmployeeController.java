package com.sandbox.company.web;

import java.util.List;

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

import com.sandbox.company.entity.Employee;
import com.sandbox.company.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeFirstName(@Valid @RequestBody Employee employee,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeFirstName(employee.getFirstName(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeLastName(@Valid @RequestBody Employee employee,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeLastName(employee.getLastName(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeAddress(@Valid @RequestBody Employee employee,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeAddress(employee.getAddress(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeCity(@Valid @RequestBody Employee employee,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeCity(employee.getCity(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeState(@Valid @RequestBody Employee employee,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeState(employee.getState(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeEmail(@Valid @RequestBody Employee employee,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeEmail(employee.getEmail(), id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
