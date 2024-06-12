package com.sandbox.company.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.PhoneNumber;
import com.sandbox.company.entity.PhoneNumberPK;

import jakarta.transaction.Transactional;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, PhoneNumberPK> {

    Optional<PhoneNumber> findByEmployeeIdAndPhone(Long employeeId, String phone);

    @Transactional
    void deleteByEmployeeIdAndPhone(Long employeeId, String phone);

}
