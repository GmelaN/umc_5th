package com.umc.springboot.converter;

import com.umc.springboot.api.code.ReviewRequestDTO;
import com.umc.springboot.domain.Review;

public class ReviewConverter {
    public static Review toReviewDTO(ReviewRequestDTO.ReviewDTO reviewRequest) {
        return Review.builder()
                .title(reviewRequest.getTitle())
                .score(reviewRequest.getScore())
                .member(reviewRequest.getMember())
                .build();
    }
}
