package com.sandbox.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.SalaryEmployee;

public interface SalaryEmployeeRepository extends CrudRepository<SalaryEmployee, Employee> {

}
