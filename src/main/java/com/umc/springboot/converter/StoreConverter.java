package com.umc.springboot.converter;

import com.umc.springboot.domain.Review;
import com.umc.springboot.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.ReviewPreviewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreViewListDTO(Page<Review> reviewList) {

        // Page<Review> -> List<StoreResponseDTO.ReviewPreviewDTO>
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList
                .stream()
                .map(StoreConverter::reviewPreViewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreviewListDTO.builder()
                .listSize(reviewPreviewDTOList.size())
                .totalElements(reviewList.getTotalElements())
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .reviewList(reviewPreviewDTOList)
                .totalPage(reviewList.getTotalPages())
                .build();

    }
}
