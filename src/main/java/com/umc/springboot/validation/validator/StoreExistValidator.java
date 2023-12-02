package com.umc.springboot.validation.validator;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.repository.StoreRepository;
import com.umc.springboot.validation.annotation.ExistCategories;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistCategories, Long> {
    private final StoreRepository storeRepository;
    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeRepository.existsById(value);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
