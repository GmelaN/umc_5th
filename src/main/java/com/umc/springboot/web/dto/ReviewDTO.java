package com.umc.springboot.web.dto;

import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.Store;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewDTO {
    @Getter
    @Builder
    public static class ReviewRequestDTO {
        private String title;
        private Float score;
        private String body;
    }

    @Getter
    @Builder
    public static class ReviewResponseDTO {
        private Long id;
        private LocalDateTime createdAt;
    }
}
