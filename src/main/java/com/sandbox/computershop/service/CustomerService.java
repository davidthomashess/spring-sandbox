package com.sandbox.computershop.service;

import java.util.List;
import java.util.Set;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();

    Set<Brand> getBrandsByCustomer(Long id);

    Customer getCustomer(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

}