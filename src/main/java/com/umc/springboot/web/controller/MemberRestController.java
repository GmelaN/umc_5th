package com.umc.springboot.web.controller;


import com.umc.springboot.converter.MissionConverter;
import com.umc.springboot.converter.StoreConverter;
import com.umc.springboot.domain.Mission;
import com.umc.springboot.domain.Review;
import com.umc.springboot.service.MemberCommandService;
import com.umc.springboot.service.MemberQueryService;
import com.umc.springboot.validation.annotation.CheckPage;
import com.umc.springboot.validation.annotation.ExistMember;
import com.umc.springboot.web.dto.MemberRequestDTO;
import com.umc.springboot.web.dto.MemberResponseDTO;
import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.converter.MemberConverter;
import com.umc.springboot.domain.Member;
import com.umc.springboot.web.dto.MissionResponseDTO;
import com.umc.springboot.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/members")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid MemberRequestDTO.JoinDTO request
            ) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }


    @PostMapping("/{memberId}/reviews")
    @Operation(summary = "특정 멤버가 작성한 리뷰 목록 API", description = "특정 멤버가 작성한 리뷰 목록 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "COMMON200",
                    description = "OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH003",
                    description = "access token 필요",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH004",
                    description = "acess 토큰 만료",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH006",
                    description = "acess 토큰 모양이 이상함",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 ID, path variable.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReview(
            @ExistMember @PathVariable(name = "memberId") @Valid Long memberId,
            @CheckPage @RequestParam(name = "page") @Valid Integer page
    ) {
        Page<Review> reviewList = memberQueryService.getReview(memberId, page - 1);
        StoreResponseDTO.ReviewPreviewListDTO result = StoreConverter
                .reviewPreViewListDTO(reviewList);

        return ApiResponse.onSuccess(result);
    }





    @PostMapping("/{memberId}/mission")
    @Operation(summary = "진행 중인 미션 목록", description = "특정 멤버의 진행 중인 미션 목록 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "COMMON200",
                    description = "OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH003",
                    description = "access token 필요",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH004",
                    description = "acess 토큰 만료",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH006",
                    description = "acess 토큰 모양이 이상함",
                    content = @Content(
                            schema = @Schema(implementation = ApiResponse.class)
                    )
            ),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 ID, path variable.")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getMission(
            @RequestParam(name = "memberId") @Valid Long memberId,
            @RequestParam(name = "type") @Valid String type,
            @CheckPage @RequestParam(name = "page") @Valid Integer page
    ) {
        Page<Mission> missionList = memberQueryService.getMission(memberId, page - 1);
        MissionResponseDTO.MissionListDTO result = MissionConverter
                .missionListDTO(missionList);

        return ApiResponse.onSuccess(result);
    }
}
