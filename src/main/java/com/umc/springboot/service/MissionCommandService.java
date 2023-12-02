package com.umc.springboot.service;

import com.umc.springboot.web.dto.MissionDTO;

public interface MissionCommandService {
    public MissionDTO.MissionResponseDTO createMission(Long storeId, MissionDTO.MissionRequestDTO missionRequest);
}
