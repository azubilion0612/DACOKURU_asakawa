package com.example.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DigitNumberValidator implements ConstraintValidator<DigitNumber, Long>{

    @Override
    public void initialize(DigitNumber digitnumber) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        int length = String.valueOf(Math.abs(value)).length();
        return length >= 1 && length <= 10;
        }
}