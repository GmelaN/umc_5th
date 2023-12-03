package com.umc.springboot.validation.validator;

import com.umc.springboot.service.MemberQueryService;
import com.umc.springboot.validation.annotation.ExistMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {
    private MemberQueryService memberQueryService;
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.memberQueryService = applicationContext.getBean(MemberQueryService.class);
    }

    @Override
    public void initialize(ExistMember constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return memberQueryService.isMemberExists(value);
    }
}
