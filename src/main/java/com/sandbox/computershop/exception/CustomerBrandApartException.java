package com.sandbox.computershop.exception;

public class CustomerBrandApartException extends RuntimeException {

    public CustomerBrandApartException(Long customerId, Long brandId) {
        super("The customer with id: '" + customerId + "' did not buy item with brand id: '" + brandId);
    }

}
