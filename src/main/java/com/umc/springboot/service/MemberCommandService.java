package com.umc.springboot.service;

import com.umc.springboot.web.dto.MemberRequestDTO;
import com.umc.springboot.domain.Member;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
