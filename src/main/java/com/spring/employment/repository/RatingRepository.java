package com.spring.employment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.spring.employment.entity.Rating;

import jakarta.transaction.Transactional;

public interface RatingRepository extends CrudRepository<Rating, Long> {

    Optional<Rating> findByEmployeeIdAndEmployerId(Long employeeId, Long employerId);

    @Transactional
    void deleteByEmployeeIdAndEmployerId(Long employeeId, Long employerId);

    List<Rating> findByEmployeeId(Long employeeId);

    List<Rating> findByEmployerId(Long employerId);

}
