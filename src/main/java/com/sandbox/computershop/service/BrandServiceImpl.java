package com.sandbox.computershop.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;
import com.sandbox.computershop.exception.BrandNotFoundException;
import com.sandbox.computershop.exception.CustomerDataIntegrityException;
import com.sandbox.computershop.exception.DeleteException;
import com.sandbox.computershop.repository.BrandRepository;
import com.sandbox.computershop.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;
    private CustomerRepository customerRepository;

    @Override
    public Brand getBrand(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);

        return unwrapBrand(brand, id);
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);

        if (brand.isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new DeleteException();
        }
    }

    @Override
    public List<Brand> getBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public Brand addCustomerToBrand(Long customerId, Long brandId) {
        Brand brand = getBrand(brandId);
        Set<Customer> boughtByCustomers = getCustomersByBrand(brandId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        Customer unwrappedCustomer = CustomerServiceImpl.unwrapCustomer(customer, customerId);

        for (Customer boughtByCustomer : boughtByCustomers) {
            if (boughtByCustomer.getId().equals(customerId)) {
                throw new CustomerDataIntegrityException(customerId, brandId);
            }
        }

        brand.getCustomers().add(unwrappedCustomer);

        return brandRepository.save(brand);
    }

    @Override
    public Set<Customer> getCustomersByBrand(Long id) {
        Brand brand = getBrand(id);

        return brand.getCustomers();
    }

    static Brand unwrapBrand(Optional<Brand> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new BrandNotFoundException(id);
    }
}