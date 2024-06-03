package com.sandbox.computershop.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;
import com.sandbox.computershop.exception.CustomerNotFoundException;
import com.sandbox.computershop.exception.DeleteException;
import com.sandbox.computershop.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return unwrapCustomer(customer, id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new DeleteException();
        }
    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Set<Brand> getBrandsByCustomer(Long id) {
        Customer customer = getCustomer(id);

        return customer.getBrands();
    }

    static Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new CustomerNotFoundException(id);
    }
}