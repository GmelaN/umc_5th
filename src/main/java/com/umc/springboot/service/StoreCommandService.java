package com.umc.springboot.service;

import com.umc.springboot.web.dto.ReviewRequestDTO;
import com.umc.springboot.domain.Store;

public interface StoreCommandService {
    Store AddReview(ReviewRequestDTO.ReviewDTO review);
}
