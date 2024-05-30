package com.spring.employment.service;

import java.util.List;
import java.util.Set;

import com.spring.employment.entity.Employer;
import com.spring.employment.entity.Employee;

public interface EmployeeService {

    Employee getEmployee(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getEmployees();

    Set<Employer> getEmployedEmployers(Long id);

}
