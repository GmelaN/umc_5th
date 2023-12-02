package com.umc.springboot.web.controller;

import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.service.ReviewCommandService;
import com.umc.springboot.web.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreRestController {

    private final ReviewCommandService reviewCommandService;
    @PostMapping("/create_review")
    ApiResponse<ReviewDTO.ReviewResponseDTO> createReview(
            Long memberId,
            Long storeId,
            @RequestBody ReviewDTO.ReviewRequestDTO reviewRequest
            ) {
        ReviewDTO.ReviewResponseDTO result = reviewCommandService.createReview(memberId, storeId, reviewRequest);
        return ApiResponse.onSuccess(result);
    }
}
