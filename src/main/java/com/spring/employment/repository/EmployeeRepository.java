package com.spring.employment.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.employment.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
