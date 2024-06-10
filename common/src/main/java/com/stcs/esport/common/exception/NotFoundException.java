package com.stcs.esport.common.exception;

import com.stcs.esport.common.model.ErrorCode;
import lombok.Getter;

public class NotFoundException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;


    public NotFoundException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

}
