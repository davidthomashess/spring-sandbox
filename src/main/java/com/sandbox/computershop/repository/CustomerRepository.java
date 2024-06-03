package com.sandbox.computershop.repository;

import org.springframework.data.repository.CrudRepository;

import com.sandbox.computershop.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
