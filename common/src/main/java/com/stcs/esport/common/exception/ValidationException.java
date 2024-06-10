package com.stcs.esport.common.exception;

import com.stcs.esport.common.model.ErrorCode;
import lombok.Getter;

public class ValidationException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;


    public ValidationException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

}