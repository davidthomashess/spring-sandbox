package com.sandbox.company.exception;

import com.sandbox.company.entity.Employee;

public class PhoneNumberDataIntegrityException extends RuntimeException {

    public PhoneNumberDataIntegrityException(Employee employeeId, Long phoneId) {
        super("The employee with id: '" + employeeId + "' already has the phone number of id: '" + phoneId + "'");
    }

}
