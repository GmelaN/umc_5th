package com.umc.springboot.service;

import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.base.handler.MemberHandler;
import com.umc.springboot.base.handler.MissionHandler;
import com.umc.springboot.domain.mapping.MemberMission;
import com.umc.springboot.repository.MemberMissionRepository;
import com.umc.springboot.repository.MemberRepository;
import com.umc.springboot.repository.MissionRepository;
import com.umc.springboot.web.dto.MemberMissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public MemberMissionDTO.MemberMissionResponseDTO startChallange(
            MemberMissionDTO.MemberMissionRequestDTO request
    ) {
        if(!memberRepository.existsById(request.getMemberId())) throw new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND);
        if(!missionRepository.existsById(request.getMissionId())) throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);

        boolean isDuplicate = memberMissionRepository.existsByMemberIdAndMissionId(
                request.getMemberId(),
                request.getMissionId()
        );

        if(isDuplicate) throw new MissionHandler(ErrorStatus.MISSION_ALREADY_EXISTS);

        MemberMission resultMemberMission = memberMissionRepository.save(toMemberMission(request));

        MemberMissionDTO.MemberMissionResponseDTO result = MemberMissionDTO.MemberMissionResponseDTO.builder()
                .createdAt(resultMemberMission.getCreatedAt())
                .member_id(resultMemberMission.getMember().getId())
                .mission_id(resultMemberMission.getMission().getId())
                .build();

        return result;
    }

    private MemberMission toMemberMission(MemberMissionDTO.MemberMissionRequestDTO request) {
        return MemberMission.builder()
                .member(
                        memberRepository.findById(request.getMemberId())
                                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND))
                )
                .mission(
                        missionRepository.findById(request.getMissionId())
                                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND))
                )
                .status(
                        request.getMissionState()
                )
                .build();
    }
}
