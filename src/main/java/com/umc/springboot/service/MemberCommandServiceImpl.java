package com.umc.springboot.service;

import com.umc.springboot.api.code.MemberRequestDTO;
import com.umc.springboot.api.code.status.ErrorStatus;
import com.umc.springboot.base.handler.FoodCategoryHandler;
import com.umc.springboot.converter.MemberConverter;
import com.umc.springboot.converter.MemberPreferConverter;
import com.umc.springboot.domain.FoodCategory;
import com.umc.springboot.domain.Member;
import com.umc.springboot.domain.mapping.MemberPrefer;
import com.umc.springboot.repository.FoodCategoryRepository;
import com.umc.springboot.repository.MemberRepository;
import com.umc.springboot.validation.annotation.ExistCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    @ExistCategories
    public Member joinMember(MemberRequestDTO.JoinDTO request) {
        Member newMember = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory()
                .stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                })
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(
                memberPrefer -> {memberPrefer.setMember(newMember);}
        );

        return memberRepository.save(newMember);
    }
}
