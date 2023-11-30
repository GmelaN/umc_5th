package com.umc.springboot.service;

import com.umc.springboot.api.code.MemberRequestDTO;
import com.umc.springboot.api.code.MemberResponseDTO;

public interface MemberQueryService {
    void validate(MemberRequestDTO.JoinDTO request);
}
