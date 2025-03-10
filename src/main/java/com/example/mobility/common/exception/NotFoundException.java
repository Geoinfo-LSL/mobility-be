package com.example.mobility.common.exception;

import com.example.mobility.common.type.ErrorTypeCode;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiExceptionImpl {
    public NotFoundException(ErrorTypeCode errorTypeCode) {
        super(errorTypeCode, HttpStatus.NOT_FOUND);
    }
}
