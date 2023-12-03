package com.umc.springboot.web.dto;

import com.umc.springboot.validation.annotation.ExistCategories;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDTO {
        @Length(min = 1, max = 255)
        String name;

        @Range(min = 0, max=3)
        Integer gender;
        @Range(min=1900, max=2100)
        Integer birthYear;
        @Range(min=1, max=12)
        Integer birthMonth;
        @Range(min=1, max=31)
        Integer birthDay;
        @Range(min=0, max=150)
        Integer age;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
