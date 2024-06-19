package com.sandbox.company.exception;

public class EmployeeWithoutPhoneNumberException extends RuntimeException {

    public EmployeeWithoutPhoneNumberException(Long employeeId, String phone) {
        super("The employee with id: " + employeeId + "' is not setup with phone number: '" + phone);
    }

}
