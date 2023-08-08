package com.woodwing.distancecalculator.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BaseExceptionResponse {
    private final int code;
    private final String reason;
    private final String description;
}
