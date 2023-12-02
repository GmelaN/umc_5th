package com.umc.springboot.service;

import com.umc.springboot.web.dto.MemberRequestDTO;

public interface MemberQueryService {
    void validate(MemberRequestDTO.JoinDTO request);
}
