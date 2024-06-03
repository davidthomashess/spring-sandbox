package com.sandbox.computershop.exception;

public class CustomerDataIntegrityException extends RuntimeException {

    public CustomerDataIntegrityException(Long customerId, Long brandId) {
        super("The customer with id: '" + customerId + "' already owns the product with brand id: '" + brandId);
    }

}
