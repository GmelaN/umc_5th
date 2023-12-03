package com.umc.springboot.service;

import com.umc.springboot.domain.Mission;
import com.umc.springboot.domain.Review;
import com.umc.springboot.web.dto.MemberRequestDTO;
import org.springframework.data.domain.Page;

public interface MemberQueryService {
    void validate(MemberRequestDTO.JoinDTO request);

    Page<Review> getReview(Long memberId, Integer page);

    Boolean isMemberExists(Long memberId);

    Page<Mission> getMission(Long memberId, Integer page);
}
