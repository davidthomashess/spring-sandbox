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

import com.sandbox.company.entity.HourlyEmployee;
import com.sandbox.company.service.HourlyEmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/hourly-employee")
public class HourlyEmployeeController {

    private HourlyEmployeeService hourlyEmployeeService;

    @GetMapping("/all")
    public ResponseEntity<List<HourlyEmployee>> getHourlyEmployees() {
        return new ResponseEntity<>(hourlyEmployeeService.getHourlyEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HourlyEmployee> getHourlyEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(hourlyEmployeeService.getHourlyEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<HourlyEmployee> saveHourlyEmployee(@Valid @RequestBody HourlyEmployee hourlyEmployee,
            @PathVariable Long id) {
        return new ResponseEntity<>(hourlyEmployeeService.saveHourlyEmployee(hourlyEmployee, id), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/hourly-rate")
    public ResponseEntity<HourlyEmployee> updateHourlyEmployeeHourlyRate(
            @Valid @RequestBody HourlyEmployee hourlyEmployee, @PathVariable Long id) {
        return new ResponseEntity<>(
                hourlyEmployeeService.updateHourlyEmployeeHourlyRate(hourlyEmployee.getHourlyRate(), id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/full-time")
    public ResponseEntity<HourlyEmployee> updateHourlyEmployeeFullTime(
            @Valid @RequestBody HourlyEmployee hourlyEmployee, @PathVariable Long id) {
        return new ResponseEntity<>(
                hourlyEmployeeService.updateHourlyEmployeeFullTime(hourlyEmployee.isFullTime(), id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteHourlyEmployee(@PathVariable Long id) {
        hourlyEmployeeService.deleteHourlyEmployee(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
