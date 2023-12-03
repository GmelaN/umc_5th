package com.umc.springboot.service;

import com.umc.springboot.web.dto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    @Override
    public void validate(MemberRequestDTO.JoinDTO request) {
        return;
    }


}
