package com.woodwing.distancecalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new BaseExceptionResponse(HttpStatus.BAD_REQUEST.value(),
                                                             HttpStatus.BAD_REQUEST.getReasonPhrase(),
                                                             exception.getMessage()));
    }
}
