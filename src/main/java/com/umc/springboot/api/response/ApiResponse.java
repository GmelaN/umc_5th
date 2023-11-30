package com.umc.springboot.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.umc.springboot.api.code.BaseCode;
import com.umc.springboot.api.code.status.SuccessStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
// isSuccess: 성공 여부, code: 응답 상황별 코드, message: 부가 설명, result: 데이터
public class ApiResponse<T> {
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;

    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


 public static <T> ApiResponse<T> onSuccess(T result){
     return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
 }

 public static <T> ApiResponse<T> of(BaseCode code, T result){
	     return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
 }

    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<T>(false, code, message, data);
    }

}
