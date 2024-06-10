package com.stcs.esport.common.advice;


import com.stcs.esport.common.dto.ErrorResponse;
import com.stcs.esport.common.exception.NotFoundException;
import com.stcs.esport.common.exception.UnauthorizedException;
import com.stcs.esport.common.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GeneralControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex) {
        log.info("Validation Error: " + ex.getErrorCode());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResponse.builder().errorCode(ex.getErrorCode()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        log.info("Not Found Error: " + ex.getErrorCode());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResponse.builder().errorCode(ex.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
        log.info("User Unauthorized: " + ex.getErrorCode());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResponse.builder().errorCode(ex.getErrorCode()).build(), HttpStatus.UNAUTHORIZED);
    }

}
