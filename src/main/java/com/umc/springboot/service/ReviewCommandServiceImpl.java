package com.umc.springboot.service;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.base.handler.MemberHandler;
import com.umc.springboot.base.handler.StoreHandler;
import com.umc.springboot.converter.ReviewConverter;
import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.Store;
import com.umc.springboot.validation.annotation.ExistStore;
import com.umc.springboot.validation.annotation.ExistMember;
import com.umc.springboot.web.dto.ReviewDTO;
import com.umc.springboot.domain.Review;
import com.umc.springboot.repository.MemberRepository;
import com.umc.springboot.repository.ReviewRepository;
import com.umc.springboot.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @ExistStore
    @ExistMember
    public ReviewDTO.ReviewResponseDTO createReview(Long memberId, Long storeId, ReviewDTO.ReviewRequestDTO reviewRequest) {
        Store store = storeRepository
                .findById(storeId)
                .orElseThrow(
                        () -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
                );

        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(
                        () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
                );

        Review review = Review.builder()
                .title(reviewRequest.getTitle())
                .score(reviewRequest.getScore())
                .store(store)
                .member(member)
                .build();

        Review createdReview = reviewRepository.save(review);
        return ReviewConverter.toReviewResponse(createdReview);
    }
}
