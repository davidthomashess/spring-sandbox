package com.sandbox.company.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.company.entity.PhoneNumber;

import jakarta.transaction.Transactional;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

    Optional<PhoneNumber> findByPhoneNumberId(Long id);

    @Transactional
    void deleteByPhoneNumberId(Long phoneId);

    List<PhoneNumber> findByEmployeeId(Long employeeId);

}
