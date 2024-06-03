package com.sandbox.computershop.service;

import java.util.List;
import java.util.Set;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;

public interface BrandService {

    Brand getBrand(Long id);

    Brand saveBrand(Brand brand);

    void deleteBrand(Long id);

    Brand addCustomerToBrand(Long customerId, Long brandId);

    List<Brand> getBrands();

    Set<Customer> getCustomersByBrand(Long id);

}
