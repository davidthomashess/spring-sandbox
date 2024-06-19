package com.sandbox.company.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

    List<PhoneNumber> findByEmployeeId(Long employeeId);

}
