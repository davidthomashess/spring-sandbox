package com.sandbox.computershop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.computershop.entity.Rating;

import jakarta.transaction.Transactional;

public interface RatingRepository extends CrudRepository<Rating, Long> {

    Optional<Rating> findByCustomerIdAndBrandId(Long customerId, Long brandId);

    @Transactional
    void deleteByCustomerIdAndBrandId(Long customerId, Long brandId);

    List<Rating> findByCustomerId(Long customerId);

    List<Rating> findByBrandId(Long brandId);

}
