package com.umc.springboot.web.controller;


import com.umc.springboot.service.MemberMissionCommandService;
import com.umc.springboot.service.MissionCommandService;
import com.umc.springboot.web.dto.MemberMissionDTO;
import com.umc.springboot.web.dto.MemberRequestDTO;
import com.umc.springboot.web.dto.MemberResponseDTO;
import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.converter.MemberConverter;
import com.umc.springboot.domain.Member;
import com.umc.springboot.service.MemberCommandServiceImpl;
import com.umc.springboot.web.dto.MissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandServiceImpl memberCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberRequestDTO.JoinDTO request
            ) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));

    }

    @PostMapping("/add_mission")
    public ApiResponse<MemberMissionDTO.MemberMissionResponseDTO> challengeMission(
            @RequestBody @Valid MemberMissionDTO.MemberMissionRequestDTO request
            ) {
        MemberMissionDTO.MemberMissionResponseDTO result = memberMissionCommandService.startChallange(request);

        return ApiResponse.onSuccess(result);
    }

}
