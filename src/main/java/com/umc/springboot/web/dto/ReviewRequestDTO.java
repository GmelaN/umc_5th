package com.umc.springboot.web.dto;

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
