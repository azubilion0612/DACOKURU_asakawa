package com.example.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DigitNumberValidator implements ConstraintValidator<DigitNumber, Integer>{

    @Override
    public void initialize(DigitNumber digitnumber) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
    int length = String.valueOf(Math.abs(value)).length();
    return length >= 1 && length <= 10;
    }
}