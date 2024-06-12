package com.sandbox.company.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneTypeValidator implements ConstraintValidator<PhoneType, String> {

    List<String> phoneType = Arrays.asList(
            "mobile",
            "home",
            "work");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext content) {
        if (value == null)
            return false;

        for (String string : phoneType) {
            if (value == string)
                return true;
        }

        return false;
    }

}
