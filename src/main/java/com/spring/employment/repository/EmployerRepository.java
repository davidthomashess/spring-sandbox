package com.spring.employment.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.employment.entity.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Long> {

}
