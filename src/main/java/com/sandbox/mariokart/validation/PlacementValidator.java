package com.sandbox.mariokart.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacementValidator implements ConstraintValidator<Placement, String> {

    List<String> placements = Arrays.asList(
            "1ST",
            "2ND",
            "3RD",
            "4TH",
            "5TH",
            "6TH",
            "7TH",
            "8TH");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        for (String string : placements) {
            if (value.equals(string))
                return true;
        }

        return false;
    }

}
