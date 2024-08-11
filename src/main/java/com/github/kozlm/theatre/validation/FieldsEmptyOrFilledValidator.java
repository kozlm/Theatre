package com.github.kozlm.theatre.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class FieldsEmptyOrFilledValidator
        implements ConstraintValidator<FieldsEmptyOrFilled, Object> {

    private String[] necessaryFieldNames;
    private String[] nonNecessaryFieldNames;

    @Override
    public void initialize(FieldsEmptyOrFilled constraintAnnotation) {
        this.necessaryFieldNames = constraintAnnotation.necessaryFieldNames();
        this.nonNecessaryFieldNames = constraintAnnotation.nonNecessaryFieldNames();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            boolean allEmpty = true;
            boolean allFilled = true;

            for (String fieldName : necessaryFieldNames) {
                Field field = value.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(value);

                if (fieldValue != null && !fieldValue.toString().isEmpty()) {
                    allEmpty = false;
                } else {
                    allFilled = false;
                }
            }

            for (String fieldName : nonNecessaryFieldNames) {
                Field field = value.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(value);

                if (fieldValue != null && !fieldValue.toString().isEmpty()) {
                    allEmpty = false;
                }
            }

            return allEmpty || allFilled;
        } catch (Exception e) {
            return false;
        }
    }
}
