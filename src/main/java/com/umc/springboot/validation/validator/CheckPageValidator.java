package com.umc.springboot.validation.validator;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.validation.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Long> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = (value > 0L);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_INDEX_OUT_OF_RANGE.toString()).addConstraintViolation();
        }

        return isValid;
    }


}
