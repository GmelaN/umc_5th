package com.umc.springboot.web.controller;

import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.service.MissionCommandService;
import com.umc.springboot.service.ReviewCommandService;
import com.umc.springboot.validation.annotation.ExistStore;
import com.umc.springboot.web.dto.MissionDTO;
import com.umc.springboot.web.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Validated
public class StoreRestController {
    private final MissionCommandService missionCommandService;
    private final ReviewCommandService reviewCommandService;
    @PostMapping("/create_review")
    @ExistStore
    ApiResponse<ReviewDTO.ReviewResponseDTO> createReview(
            Long memberId,
            Long storeId,
            @RequestBody @Valid ReviewDTO.ReviewRequestDTO reviewRequest
            ) {
        ReviewDTO.ReviewResponseDTO result = reviewCommandService.createReview(memberId, storeId, reviewRequest);
        return ApiResponse.onSuccess(result);
    }

    @PostMapping("/create_mission")
//    @ExistStore
    ApiResponse<MissionDTO.MissionResponseDTO> createMission(
            Long storeId,
            @RequestBody @Valid MissionDTO.MissionRequestDTO missionRequest
            ) {
        MissionDTO.MissionResponseDTO result = missionCommandService.createMission(storeId, missionRequest);
        return ApiResponse.onSuccess(result);
    }


}
