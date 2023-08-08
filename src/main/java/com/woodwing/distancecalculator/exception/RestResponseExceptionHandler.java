package com.woodwing.distancecalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        return new ResponseEntity<>(new BaseExceptionResponse(HttpStatus.BAD_REQUEST.value(),
                                                             HttpStatus.BAD_REQUEST.getReasonPhrase(),
                                                             exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
