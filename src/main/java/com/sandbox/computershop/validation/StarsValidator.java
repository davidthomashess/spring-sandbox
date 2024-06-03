package com.sandbox.computershop.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StarsValidator implements ConstraintValidator<Stars, Integer> {

    List<Integer> stars = Arrays.asList(1, 2, 3, 4, 5);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        for (Integer integer : stars) {
            if (value == integer)
                return true;
        }

        return false;
    }

}
