package com.umc.springboot.api.code;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
    
}
