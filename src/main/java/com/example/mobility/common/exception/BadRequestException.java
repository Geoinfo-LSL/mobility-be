package com.example.simulation.common.exception;

import com.example.simulation.common.type.ErrorTypeCode;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiExceptionImpl {
    public BadRequestException(ErrorTypeCode errorTypeCode) {
        super(errorTypeCode, HttpStatus.BAD_REQUEST);
    }
}
