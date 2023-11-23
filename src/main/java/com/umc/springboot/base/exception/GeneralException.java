package com.umc.springboot.base.exception;

import com.umc.springboot.api.code.BaseErrorCode;
import com.umc.springboot.api.code.ErrorReasonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
