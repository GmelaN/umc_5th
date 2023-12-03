package com.umc.springboot.converter;

import com.umc.springboot.web.dto.MemberRequestDTO;
import com.umc.springboot.web.dto.MemberResponseDTO;
import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        Gender gender = null;

        Integer genderCode = request.getGender();
        if(genderCode == 1) gender = Gender.MALE;
        else if(genderCode == 2) gender = Gender.FEMALE;
        else gender = Gender.NONE;

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .age(request.getAge())
                .memberPreferList(new ArrayList<>())
                .build();

    }

}
