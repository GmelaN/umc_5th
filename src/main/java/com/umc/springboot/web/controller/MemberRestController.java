package com.umc.springboot.web.controller;


import com.umc.springboot.web.dto.MemberRequestDTO;
import com.umc.springboot.web.dto.MemberResponseDTO;
import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.converter.MemberConverter;
import com.umc.springboot.domain.Member;
import com.umc.springboot.service.MemberCommandServiceImpl;
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

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberRequestDTO.JoinDTO request
            ) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));

    }
}
