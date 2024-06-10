package com.stcs.esport.common.dto;


import com.stcs.esport.common.model.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {

    private ErrorCode errorCode;

}
