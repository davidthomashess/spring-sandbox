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
import com.sandbox.company.update.EmployeeAddress;
import com.sandbox.company.update.EmployeeCity;
import com.sandbox.company.update.EmployeeEmail;
import com.sandbox.company.update.EmployeeFirstName;
import com.sandbox.company.update.EmployeeLastName;
import com.sandbox.company.update.EmployeeState;

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

    @PutMapping("/{id}/first-name")
    public ResponseEntity<Employee> updateEmployeeFirstName(@Valid @RequestBody EmployeeFirstName employeeFirstName,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeFirstName(employeeFirstName.getFirstName(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/last-name")
    public ResponseEntity<Employee> updateEmployeeLastName(@Valid @RequestBody EmployeeLastName employeeLastName,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeLastName(employeeLastName.getLastName(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Employee> updateEmployeeAddress(@Valid @RequestBody EmployeeAddress employeeAddress,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeAddress(employeeAddress.getAddress(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/city")
    public ResponseEntity<Employee> updateEmployeeCity(@Valid @RequestBody EmployeeCity employeeCity,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeCity(employeeCity.getCity(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/state")
    public ResponseEntity<Employee> updateEmployeeState(@Valid @RequestBody EmployeeState employeeState,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeState(employeeState.getState(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Employee> updateEmployeeEmail(@Valid @RequestBody EmployeeEmail employeeEmail,
            @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployeeEmail(employeeEmail.getEmail(), id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
