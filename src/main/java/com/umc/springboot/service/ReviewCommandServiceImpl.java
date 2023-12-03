//package com.umc.springboot.service;
//
//import com.umc.springboot.web.dto.ReviewRequestDTO;
//import com.umc.springboot.domain.Review;
//import com.umc.springboot.repository.MemberRepository;
//import com.umc.springboot.repository.ReviewRepository;
//import com.umc.springboot.repository.StoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ReviewCommandServiceImpl implements ReviewCommandService {
//    private final ReviewRepository reviewRepository;
//    private final MemberRepository memberRepository;
//    private final StoreRepository storeRepository;

//    @Override
//    public Review WriteReview(ReviewRequestDTO.ReviewDTO reviewRequest) {
        // TODO: Store, Member 엔티티를 조회 및 가져와서 review에 넣고 save
//        storeRepository.getReferenceById();
//
//
//        Review review = Review.builder()
//                        .title(reviewRequest.getTitle())
//                        .score(reviewRequest.getScore())
//                        .build();
//
//        reviewRepository.save();
//    }
//}
