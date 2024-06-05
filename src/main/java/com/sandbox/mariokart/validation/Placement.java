package com.sandbox.mariokart.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PlacementValidator.class)
public @interface Placement {

    String message() default "Not a valid placement value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
