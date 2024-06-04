package com.sandbox.computershop.exception;

public class CustomerWithoutBrandException extends RuntimeException {

    public CustomerWithoutBrandException(Long customerId, Long brandId) {
        super("The customer with id: '" + customerId + "' did not buy item with brand id: '" + brandId);
    }

}
