package com.umc.springboot.api.code;

import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.Store;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDTO {
        private Long id;
        private String title;
        private Float score;
        private Member member;
        private Store store;
    }
}
