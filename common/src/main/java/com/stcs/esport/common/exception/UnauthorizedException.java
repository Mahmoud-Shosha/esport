package com.stcs.esport.common.exception;

import com.stcs.esport.common.model.ErrorCode;
import lombok.Getter;

public class UnauthorizedException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;


    public UnauthorizedException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

}
