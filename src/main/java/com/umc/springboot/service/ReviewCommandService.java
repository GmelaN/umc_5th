package com.umc.springboot.service;

import com.umc.springboot.web.dto.ReviewDTO;

public interface ReviewCommandService {
    ReviewDTO.ReviewResponseDTO createReview(Long memberId, Long storeId, ReviewDTO.ReviewRequestDTO reviewRequest);
}
