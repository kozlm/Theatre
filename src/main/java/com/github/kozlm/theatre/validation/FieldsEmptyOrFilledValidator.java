package com.github.kozlm.theatre.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class FieldsEmptyOrFilledValidator
        implements ConstraintValidator<FieldsEmptyOrFilled, Object> {

    private String[] fieldNames;

    @Override
    public void initialize(FieldsEmptyOrFilled constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fieldNames();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            boolean allEmpty = true;
            boolean allFilled = true;

            for (String fieldName : fieldNames) {
                Field field = value.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(value);

                if (fieldValue != null && !fieldValue.toString().isEmpty()) {
                    allEmpty = false;
                } else {
                    allFilled = false;
                }
            }

            return allEmpty || allFilled;
        } catch (Exception e) {
            return false;
        }
    }
}
