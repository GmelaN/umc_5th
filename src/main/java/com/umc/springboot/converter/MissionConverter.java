package com.umc.springboot.converter;

import com.umc.springboot.domain.Mission;
import com.umc.springboot.web.dto.MissionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

public class MissionConverter {
    @Builder
    public static MissionResponseDTO.MissionListDTO missionListDTO(Page<Mission> mission) {
        return null;
    }

}
