package com.umc.springboot.service;

import com.umc.springboot.web.dto.MemberMissionDTO;


public interface MemberMissionCommandService {
    public MemberMissionDTO.MemberMissionResponseDTO startChallange(
            MemberMissionDTO.MemberMissionRequestDTO request
            );
}
