package com.example.mobility.common.exception;

import com.example.mobility.common.type.ErrorTypeCode;
import org.springframework.http.HttpStatus;

public interface ApiException {
    ErrorTypeCode getTypeCode();

    HttpStatus getHttpStatus();
}
