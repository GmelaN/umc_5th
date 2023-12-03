package com.umc.springboot.web.dto;

import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.Store;
import com.umc.springboot.domain.enums.Gender;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDTO {
        private Long id;
        private String title;
        private Float score;
        private Integer gender;
        private Long memberId;
        private Long storeId;
    }
}
