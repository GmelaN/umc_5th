package com.umc.springboot.api.code.status;

import org.springframework.http.HttpStatus;

import com.umc.springboot.api.code.BaseCode;
import com.umc.springboot.api.code.ReasonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "COMMON200", "정상 처리되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}
