package com.example.simulation.common.exception;

import com.example.simulation.common.type.ErrorTypeCode;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiExceptionImpl {
    public UnauthorizedException(ErrorTypeCode errorTypeCode) {
        super(errorTypeCode, HttpStatus.UNAUTHORIZED);
    }
}
