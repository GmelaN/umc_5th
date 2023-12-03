package com.umc.springboot.service;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.base.handler.MemberHandler;
import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.Mission;
import com.umc.springboot.domain.Review;
import com.umc.springboot.repository.MemberRepository;
import com.umc.springboot.repository.ReviewRepository;
import com.umc.springboot.repository.StoreRepository;
import com.umc.springboot.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public void validate(MemberRequestDTO.JoinDTO request) {
        return;
    }

    public Page<Review> getReview(Long memberId, Integer page) {
        Member targetMember = memberRepository
                        .findById(memberId)
                        .orElseThrow(
                                () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
                        );

        Page<Review> result = reviewRepository.findAllByMember(
                targetMember,
                PageRequest.of(page, 10)
        );

        return result;
    }

    public Boolean isMemberExists(Long memberId) {
        return memberRepository.existsById(memberId);
    }

    public Page<Mission> getMission(Long memberId, Integer page) {
        Member targetMember = memberRepository
                .findById(memberId)
                .orElseThrow(
                        () -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
                );

        return null;
    }
}
