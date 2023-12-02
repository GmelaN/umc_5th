package com.umc.springboot.converter;

import com.umc.springboot.web.dto.ReviewDTO;
import com.umc.springboot.domain.Review;

public class ReviewConverter {
    public static Review toReview(ReviewDTO.ReviewRequestDTO reviewRequest) {
        return Review.builder()
                .title(reviewRequest.getTitle())
                .score(reviewRequest.getScore())
                .body(reviewRequest.getBody())
                .build();
    }

    public static ReviewDTO.ReviewResponseDTO toReviewResponse(Review review) {
        return ReviewDTO.ReviewResponseDTO.builder()
                .createdAt(review.getCreatedAt())
                .id(review.getId())
                .build();
    }
}
