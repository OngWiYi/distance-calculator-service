package com.woodwing.distancecalculator.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseExceptionResponse {
    private final int code;
    private final String reason;
    private final String description;
}
