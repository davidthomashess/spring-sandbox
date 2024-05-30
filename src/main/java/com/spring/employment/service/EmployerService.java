package com.spring.employment.service;

import java.util.List;
import java.util.Set;

import com.spring.employment.entity.Employer;
import com.spring.employment.entity.Employee;

public interface EmployerService {

    Employer getEmployer(Long id);

    Employer saveEmployer(Employer employer);

    void deleteEmployer(Long id);

    Employer addEmployeeToEmployer(Long employeeId, Long employerId);

    List<Employer> getEmployers();

    Set<Employee> getEmployedEmployees(Long id);

}
