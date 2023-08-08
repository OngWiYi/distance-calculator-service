package com.woodwing.distancecalculator.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Request body for sum distance API
 */
@Getter
@Setter
public class SumDistanceRequestBody {
    private String firstDistance;
    private String firstDistanceUnit;
    private String secondDistance;
    private String secondDistanceUnit;
    private String responseUnit;
}
