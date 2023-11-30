package com.umc.springboot.service;

import com.umc.springboot.api.code.MemberRequestDTO;
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
