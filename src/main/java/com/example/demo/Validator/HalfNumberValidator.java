package com.example.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HalfNumberValidator implements ConstraintValidator<HalfNumber, Long> {

    @Override
    public void initialize(HalfNumber halfnumber) {
    }
    
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String strValue = String.valueOf(value);
        return strValue.matches("\\d+");
        }

}
