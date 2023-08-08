package com.woodwing.distancecalculator.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Response body for sum distance API
 */
@Getter
@Setter
public class SumDistanceResponseBody {
    private float totalDistance;
    private String distanceUnit;
}
