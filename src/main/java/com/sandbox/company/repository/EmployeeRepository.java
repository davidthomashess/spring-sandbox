package com.sandbox.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
