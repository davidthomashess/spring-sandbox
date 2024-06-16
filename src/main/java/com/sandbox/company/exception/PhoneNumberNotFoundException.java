package com.sandbox.company.exception;

public class PhoneNumberNotFoundException extends RuntimeException {

    public PhoneNumberNotFoundException(String phone) {
        super("The phone number '" + phone + "' does not exist in our records");
    }

}
