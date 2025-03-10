package com.example.simulation.common.exception;

import com.example.simulation.common.type.ErrorTypeCode;
import org.springframework.http.HttpStatus;

public interface ApiException {
    ErrorTypeCode getTypeCode();

    HttpStatus getHttpStatus();
}
