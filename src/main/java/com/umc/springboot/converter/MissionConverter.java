package com.umc.springboot.converter;

import com.umc.springboot.domain.Mission;
import com.umc.springboot.web.dto.MissionDTO;

public class MissionConverter {
    public static Mission toMission(MissionDTO.MissionRequestDTO missionRequest) {
        return Mission.builder()
                .missionSpec(missionRequest.getMissionSpec())
                .reward(missionRequest.getReward())
                .deadline(missionRequest.getDeadline())
                .build();
    }

    public static MissionDTO.MissionResponseDTO toMissionResponse(Mission mission) {
        return MissionDTO.MissionResponseDTO.builder()
                .createdAt(mission.getCreatedAt())
                .id(mission.getId())
                .build();
    }
}
