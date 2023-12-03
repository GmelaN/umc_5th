package com.umc.springboot.service;

import com.umc.springboot.web.dto.ReviewRequestDTO;
import com.umc.springboot.domain.Review;

public interface ReviewCommandService {
    Review WriteReview(ReviewRequestDTO.ReviewDTO reviewRequest);
}
