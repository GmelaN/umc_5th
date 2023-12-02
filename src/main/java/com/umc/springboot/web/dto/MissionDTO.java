package com.umc.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionDTO {
    @Getter
    @Builder
    public static class MissionRequestDTO {
        @Range(min = 0, max = 1000000)
        private Integer reward;

        private LocalDate deadline;

        @Length(min = 5, max = 2000)
        private String missionSpec;
    }

    @Getter
    @Builder
    public static class MissionResponseDTO {
        private LocalDateTime createdAt;
        private Long id;
    }
}
