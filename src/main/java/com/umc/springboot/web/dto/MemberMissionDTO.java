package com.umc.springboot.web.dto;

import com.umc.springboot.domain.enums.MissionStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberMissionDTO {
    @Getter
    @Builder
    public static class MemberMissionRequestDTO {
        private Long memberId;
        private Long missionId;
        private MissionStatus missionState;
    }

    @Getter
    @Builder
    public static class MemberMissionResponseDTO {
        private LocalDateTime createdAt;
        private Long member_id;
        private Long mission_id;
    }
}
