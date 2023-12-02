package com.umc.springboot.web.dto;

import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.Store;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

public class ReviewDTO {
    @Getter
    @Builder
    public static class ReviewRequestDTO {
        @Length(min = 1, max = 50)
        private String title;
        @Range(min = 0, max = 5)
        private Float score;
        @Length(min = 5, max = 1000)
        private String body;
    }

    @Getter
    @Builder
    public static class ReviewResponseDTO {
        private Long id;
        private LocalDateTime createdAt;
    }
}
