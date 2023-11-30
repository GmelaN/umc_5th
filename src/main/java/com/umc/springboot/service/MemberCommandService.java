package com.umc.springboot.service;

import com.umc.springboot.api.code.MemberRequestDTO;
import com.umc.springboot.domain.Member;
import org.springframework.stereotype.Service;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
