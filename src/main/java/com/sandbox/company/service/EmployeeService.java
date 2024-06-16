package com.sandbox.company.service;

import java.util.List;

import com.sandbox.company.entity.Employee;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployeeFirstName(String firstName, Long id);

    Employee updateEmployeeLastName(String lastName, Long id);

    Employee updateEmployeeAddress(String address, Long id);

    Employee updateEmployeeCity(String city, Long id);

    Employee updateEmployeeState(String state, Long id);

    Employee updateEmployeeEmail(String email, Long id);

    void deleteEmployee(Long id);

}
