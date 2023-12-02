package com.umc.springboot.service;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.base.handler.StoreHandler;
import com.umc.springboot.converter.MissionConverter;
import com.umc.springboot.domain.Mission;
import com.umc.springboot.domain.Store;
import com.umc.springboot.repository.MissionRepository;
import com.umc.springboot.repository.StoreRepository;
import com.umc.springboot.web.dto.MissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    public MissionDTO.MissionResponseDTO createMission(Long storeId, MissionDTO.MissionRequestDTO missionRequest) {
        Store store = storeRepository
                .findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = Mission.builder()
                .missionSpec(missionRequest.getMissionSpec())
                .reward(missionRequest.getReward())
                .deadline(missionRequest.getDeadline())
                .store(store)
                .build();

        Mission createdMission = missionRepository.save(mission);
        MissionDTO.MissionResponseDTO missionResponse = MissionConverter.toMissionResponse(createdMission);

        return missionResponse;
    }
}
