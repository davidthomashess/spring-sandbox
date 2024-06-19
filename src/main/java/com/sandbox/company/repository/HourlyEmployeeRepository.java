package com.sandbox.company.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.HourlyEmployee;

import jakarta.transaction.Transactional;

public interface HourlyEmployeeRepository extends CrudRepository<HourlyEmployee, Long> {

    Optional<HourlyEmployee> findByEmployeeId(Long employeeId);

    @Transactional
    void deleteByEmployeeId(Long employeeId);

}
