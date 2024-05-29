package com.spring.employment.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidator implements ConstraintValidator<Rating, Integer> {

    List<Integer> ratings = Arrays.asList(1, 2, 3, 4, 5);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        for (Integer integer : ratings) {
            if (value.equals(integer))
                return true;
        }

        return false;
    }

}
