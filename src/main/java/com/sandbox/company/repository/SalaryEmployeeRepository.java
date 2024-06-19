package com.sandbox.company.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.SalaryEmployee;

import jakarta.transaction.Transactional;

public interface SalaryEmployeeRepository extends CrudRepository<SalaryEmployee, Long> {

    Optional<SalaryEmployee> findByEmployeeId(Long employeeId);

    @Transactional
    void deleteByEmployeeId(Long employeeId);

}
