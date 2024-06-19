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

import com.sandbox.company.entity.SalaryEmployee;
import com.sandbox.company.service.SalaryEmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/salary-employee")
public class SalaryEmployeeController {

    private SalaryEmployeeService salaryEmployeeService;

    @GetMapping("/all")
    public ResponseEntity<List<SalaryEmployee>> getSalaryEmployees() {
        return new ResponseEntity<>(salaryEmployeeService.getSalaryEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryEmployee> getSalaryEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(salaryEmployeeService.getSalaryEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<SalaryEmployee> saveSalaryEmployee(@Valid @RequestBody SalaryEmployee salaryEmployee,
            @PathVariable Long id) {
        return new ResponseEntity<>(salaryEmployeeService.saveSalaryEmployee(salaryEmployee, id), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/salary-rate")
    public ResponseEntity<SalaryEmployee> updateSalaryEmployeeSalaryRate(
            @Valid @RequestBody SalaryEmployee salaryEmployee, @PathVariable Long id) {
        return new ResponseEntity<>(
                salaryEmployeeService.updateSalaryEmployeeSalaryRate(salaryEmployee.getSalaryRate(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/full-time")
    public ResponseEntity<SalaryEmployee> updateSalaryEmployeeFullTime(
            @Valid @RequestBody SalaryEmployee salaryEmployee, @PathVariable Long id) {
        return new ResponseEntity<>(
                salaryEmployeeService.updateSalaryEmployeeFullTime(salaryEmployee.isFullTime(), id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSalaryEmployee(@PathVariable Long id) {
        salaryEmployeeService.deleteSalaryEmployee(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
