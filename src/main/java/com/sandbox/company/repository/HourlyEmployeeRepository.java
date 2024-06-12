package com.sandbox.company.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.Employee;
import com.sandbox.company.entity.HourlyEmployee;

public interface HourlyEmployeeRepository extends CrudRepository<HourlyEmployee, Employee> {

}
