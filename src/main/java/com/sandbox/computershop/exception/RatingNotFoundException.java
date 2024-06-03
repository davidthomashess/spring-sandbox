package com.sandbox.computershop.exception;

public class RatingNotFoundException extends RuntimeException {

    public RatingNotFoundException(Long customerId, Long brandId) {
        super("The rating with customer id: '" + customerId + "' and brand id: '" + brandId
                + "' does not exist in our records");
    }

}
