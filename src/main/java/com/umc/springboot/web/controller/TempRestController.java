package com.umc.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umc.springboot.api.response.ApiResponse;
import com.umc.springboot.converter.TempConverter;
import com.umc.springboot.service.TempQueryService;
import com.umc.springboot.web.dto.TempResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
        tempQueryService.checkFlag(flag);

        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
