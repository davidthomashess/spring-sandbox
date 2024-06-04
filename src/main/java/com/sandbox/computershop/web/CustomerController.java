package com.sandbox.computershop.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;
import com.sandbox.computershop.service.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}/brands")
    public ResponseEntity<Set<Brand>> getBrandsByCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getBrandsByCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
