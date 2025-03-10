package com.example.mobility.common.exception;

import com.example.mobility.common.type.ErrorTypeCode;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiExceptionImpl {
    public UnauthorizedException(ErrorTypeCode errorTypeCode) {
        super(errorTypeCode, HttpStatus.UNAUTHORIZED);
    }
}
