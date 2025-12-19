package com.example.demo.Validator;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateFormatValidator implements ConstraintValidator<DateFormat, LocalDate>{

    @Override
    public void initialize(DateFormat dateformat) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String strValue = String.valueOf(value);
        return strValue.matches("^\\d{4}-\\d{2}-\\d{2}$");
        }
}