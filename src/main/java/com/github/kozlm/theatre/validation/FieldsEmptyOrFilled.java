package com.github.kozlm.theatre.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsEmptyOrFilledValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsEmptyOrFilled {
    String message() default "Fields must be either all empty or all filled";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] necessaryFieldNames();
    String[] nonNecessaryFieldNames();
}