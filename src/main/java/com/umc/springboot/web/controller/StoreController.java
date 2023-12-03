package com.umc.springboot.web.controller;

import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.service.StoreQueryService;
import com.umc.springboot.validation.annotation.ExistStore;
import com.umc.springboot.web.dto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreQueryService storeQueryService;
    @GetMapping("./{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰 목록 조회")
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
            @Parameter(name = "storeId", description = "가게의 ID, path variable.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewList(
            @ExistStore @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page
    ) {
        storeQueryService.getReview(storeId, page);



        return null;
    }
}
