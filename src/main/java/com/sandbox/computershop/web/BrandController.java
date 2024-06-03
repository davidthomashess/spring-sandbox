package com.sandbox.computershop.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.computershop.entity.Brand;
import com.sandbox.computershop.entity.Customer;
import com.sandbox.computershop.service.BrandService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/brand")
public class BrandController {

    BrandService brandService;

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable Long id) {
        return new ResponseEntity<>(brandService.getBrand(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Brand> saveBrand(@Valid @RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.saveBrand(brand), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Brand>> getBrands() {
        return new ResponseEntity<>(brandService.getBrands(), HttpStatus.OK);
    }

    @PutMapping("/{brandId}/customer/{customerId}")
    public ResponseEntity<Brand> addCustomerToBrand(@PathVariable Long brandId, @PathVariable Long customerId) {
        return new ResponseEntity<>(brandService.addCustomerToBrand(customerId, brandId), HttpStatus.OK);
    }

    @GetMapping("/{id}/customers")
    public ResponseEntity<Set<Customer>> getCustomersByBrand(Long id) {
        return new ResponseEntity<>(brandService.getCustomersByBrand(id), HttpStatus.OK);
    }

}
