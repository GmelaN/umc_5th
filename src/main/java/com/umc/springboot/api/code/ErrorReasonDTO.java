package com.umc.springboot.api.code;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorReasonDTO {
    private HttpStatus httpStatus;

    private final boolean isSuccess;
    private final String code;
    private final String message;

    public Boolean getIsSuccess() {
        return this.isSuccess;
    }
}
